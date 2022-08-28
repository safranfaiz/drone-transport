package com.safran.dronetransport.service;

import com.safran.dronetransport.entity.*;
import com.safran.dronetransport.repo.DispatchLoadRepository;
import com.safran.dronetransport.repo.MedicationLoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DispatchLoadServiceImpl implements DispatchLoadService{

    @Autowired
    DroneService droneService;

    @Autowired
    MedicationService medicationService;

    @Autowired
    DispatchLoadRepository dispatchLoadRepository;

    @Autowired
    MedicationLoadRepository medicationLoadRepository;

    @Override
    public DispatchLoad createDispatch() {
        Drone drone = new Drone();
        drone.setSerialNumber(555);
        drone.setBatteryCapacity(55);
        drone.setModel(DroneModel.Lightweight);
        drone.setDroneState(DroneState.IDLE);

        drone = droneService.createDrone(drone);

        Medication medication1 = new Medication();
        medication1.setName("sss");
        medication1.setCode("ASD222");

        medication1 = medicationService.createMedication(medication1);

        Medication medication2 = new Medication();
        medication2.setName("bbbb");
        medication2.setCode("BBB3232");

        medication2 = medicationService.createMedication(medication2);

        MedicationLoad medicationLoad1 = new MedicationLoad();
        medicationLoad1.setMedication(medication1);
        medicationLoad1.setQty(10);
        medicationLoad1.setTotal(300);

        MedicationLoad medicationLoad2 = new MedicationLoad();
        medicationLoad2.setMedication(medication2);
        medicationLoad2.setQty(3);
        medicationLoad2.setTotal(66);

        DispatchLoad dispatchLoad = new DispatchLoad();
        dispatchLoad.setDrone(drone);
//        dispatchLoad.setMedicationLoads(Arrays.asList(medicationLoad1, medicationLoad2));

        dispatchLoad = dispatchLoadRepository.save(dispatchLoad);
        medicationLoad1.setDispatchLoad(dispatchLoad);
        medicationLoad2.setDispatchLoad(dispatchLoad);
        medicationLoadRepository.save(medicationLoad1);
        medicationLoadRepository.save(medicationLoad2);
        return dispatchLoad;

    }

    public List<DispatchLoad> findAll(){
        return dispatchLoadRepository.findAll();
    }
}
