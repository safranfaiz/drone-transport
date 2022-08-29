package com.safran.dronetransport.agent;

import com.safran.dronetransport.dto.LoadDispatcherDroneDTO;
import com.safran.dronetransport.dto.LoadDispatcherMedicationDTO;
import com.safran.dronetransport.entity.*;
import com.safran.dronetransport.service.DispatchLoadService;
import com.safran.dronetransport.service.DroneService;
import com.safran.dronetransport.service.MedicationLoadService;
import com.safran.dronetransport.service.MedicationService;
import com.safran.dronetransport.specification.DroneRequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispatchAgent {

    @Autowired
    DroneRequestSpecification droneRequestSpecification;

    @Autowired
    MedicationService medicationService;

    @Autowired
    DroneService droneService;

    @Autowired
    DroneAgent droneAgent;

    @Autowired
    DispatchLoadService dispatchLoadService;

    @Autowired
    MedicationLoadService medicationLoadService;

    public DispatchLoad loadDispatchMedicine(LoadDispatcherDroneDTO dispatcherDroneDTO){
        // check drone is exist, battery capacity and state
        Drone drone = droneAgent.droneBySerialNumber(dispatcherDroneDTO.getSerialNumber());
        droneRequestSpecification.checkDroneBatteryPercentage(drone.getBatteryCapacity());
        droneRequestSpecification.droneStateIsIDEL(drone.getDroneState());

        //todo change below enhanced for loop to Java 8
        long medicationWeight = 0;
        DispatchLoad dispatchLoad = new DispatchLoad();
        for(LoadDispatcherMedicationDTO loadDispatcherMedicationDTO: dispatcherDroneDTO.getLoadDispatcherMedicationDTOs()){
            Medication medication = medicationService.findByMedicationCode( loadDispatcherMedicationDTO.getCode());
            long temp = medication.getWeight() * loadDispatcherMedicationDTO.getQty();
            medicationWeight = medicationWeight + temp;
            if (medicationWeight > drone.getWeight()){
                throw new RuntimeException("Drone Weight exceed");
            }

            // change drone state IDLE to LOADING
            if(drone.getDroneState() != DroneState.LOADING) {
                drone.setDroneState(DroneState.LOADING);
                drone = droneService.changeDroneState(drone);
            }

            // save dispatch
            dispatchLoad.setDrone(drone);
            dispatchLoad = dispatchLoadService.createDispatch(dispatchLoad);

            // save medication
            MedicationLoad medicationLoad = new MedicationLoad();
            medicationLoad.setMedication(medication);
            medicationLoad.setQty(loadDispatcherMedicationDTO.getQty());
            medicationLoad.setTotal(medicationWeight);
            medicationLoad.setDispatchLoad(dispatchLoad);

            medicationLoadService.createMedicationLoad(medicationLoad);
        }

        // change drone status
        drone.setDroneState(DroneState.LOADED);
        droneService.changeDroneState(drone);
        return dispatchLoad;

    }
}
