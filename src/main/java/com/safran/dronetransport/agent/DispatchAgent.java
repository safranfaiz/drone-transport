package com.safran.dronetransport.agent;

import com.safran.dronetransport.convertor.DispatchConverter;
import com.safran.dronetransport.convertor.DroneConverter;
import com.safran.dronetransport.convertor.MedicationLoadConverter;
import com.safran.dronetransport.dto.*;
import com.safran.dronetransport.entity.*;
import com.safran.dronetransport.exception.ResourceNotFoundException;
import com.safran.dronetransport.service.DispatchLoadService;
import com.safran.dronetransport.service.DroneService;
import com.safran.dronetransport.service.MedicationLoadService;
import com.safran.dronetransport.service.MedicationService;
import com.safran.dronetransport.specification.DroneRequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class DispatchAgent {

    @Autowired
    DroneRequestSpecification droneRequestSpecification;

    @Autowired
    MedicationService medicationService;

    @Autowired
    DroneService droneService;

    @Autowired
    DispatchLoadService dispatchLoadService;

    @Autowired
    MedicationLoadService medicationLoadService;

    @Autowired
    DispatchConverter dispatchConverter;

    @Autowired
    DroneConverter droneConverter;

    @Autowired
    MedicationLoadConverter medicationLoadConverter;

    /**
     * Medications load to the drone and change the drone state as well
     *
     * @param dispatcherDroneDTO
     * @return DispatchLoadResponseDTO
     */
    @Transactional
    public DispatchLoadResponseDTO loadDispatchMedicine(LoadDispatcherDroneDTO dispatcherDroneDTO) {
        // check drone is exist, battery capacity and state
        Drone drone = droneService.getDroneBySerialNumber(dispatcherDroneDTO.getSerialNumber());
        droneRequestSpecification.checkDroneValidityForLoading(drone);
        droneService.changeDroneState(drone, DroneState.LOADING);
        DispatchLoad dispatchLoad = createDispatchLoad(drone);

        dispatchLoad.setTotalWeight(validateAndCreateMedicationLoad(dispatcherDroneDTO, drone, dispatchLoad));
        dispatchLoad = updateDispatchLoad(dispatchLoad);

        // change drone status
        droneService.changeDroneState(drone, DroneState.LOADED);
        return buildDispatchLoadResponse(dispatchLoad);
    }

    private DispatchLoad updateDispatchLoad(DispatchLoad dispatchLoad) {
        return dispatchLoadService.createDispatch(dispatchLoad);
    }

    private MedicationLoad createMedicationLoad(Medication medication, Long qty, Long totalWeight, DispatchLoad dispatchLoad) {
        MedicationLoad medicationLoad = new MedicationLoad();
        medicationLoad.setMedication(medication);
        medicationLoad.setQty(qty);
        medicationLoad.setTotal(totalWeight);
        medicationLoad.setDispatchLoad(dispatchLoad);

        return medicationLoad;
    }

    private Long validateAndCreateMedicationLoad(LoadDispatcherDroneDTO dispatcherDroneDTO, Drone drone, DispatchLoad dispatchLoad) {
        Long totalWeight = 0L;
        List<MedicationLoad> medicationLoads = new ArrayList<>();
        List<String> inValidMedications = new ArrayList<>();
        for (LoadDispatcherMedicationDTO loadDispatcherMedicationDTO : dispatcherDroneDTO.getLoadDispatcherMedicationDTOs()) {
            try {
                Medication medication = medicationService.findByMedicationCode(loadDispatcherMedicationDTO.getCode());
                Long medicationWeight = medication.getWeight() * loadDispatcherMedicationDTO.getQty();
                totalWeight = totalWeight + medicationWeight;
                medicationLoads.add(createMedicationLoad(medication, loadDispatcherMedicationDTO.getQty(), medicationWeight, dispatchLoad));
            } catch (ResourceNotFoundException e) {
                log.error("Medication Not found {}", loadDispatcherMedicationDTO.getCode());
                inValidMedications.add(loadDispatcherMedicationDTO.getCode());
            }
        }

        if (!inValidMedications.isEmpty()) {
            throw new RuntimeException("Invalid Medication codes found: " + inValidMedications);
        }

        if (totalWeight > drone.getWeight()) {
            throw new RuntimeException("Maximum Drone weight " + drone.getWeight() + "g");
        }
        medicationLoads.forEach(medicationLoadService::createMedicationLoad);
        dispatchLoad.setMedicationLoads(medicationLoads);
        return totalWeight;
    }

    private DispatchLoad createDispatchLoad(Drone drone) {
        DispatchLoad dispatchLoad = new DispatchLoad();
        dispatchLoad.setDrone(drone);
        return dispatchLoadService.createDispatch(dispatchLoad);
    }

    /**
     * retrieve all drones which are dispatch with items
     *
     * @return List<DispatchLoad>
     */
    public List<DispatchLoadResponseDTO> loadDispatchDroneWithItems() {
        return dispatchLoadService.findAll().stream().map(this::buildDispatchLoadResponse).collect(Collectors.toList());
    }

    public DispatchLoad getDispatchLoadBySerialNumber(Long serialNumber) {
        return dispatchLoadService.findByDroneSerialNumber(serialNumber);
    }

    private DispatchLoadResponseDTO buildDispatchLoadResponse(DispatchLoad dispatchLoad) {
        DroneResponseDTO droneResponseDTO = droneConverter.convertToDroneResponseDTO(dispatchLoad.getDrone());
        List<MedicationLoadResponseDTO> medicationLoadResponseDTOS = dispatchLoad.getMedicationLoads().stream().map(medicationLoadConverter::convertToMedicationLoadResponse).collect(Collectors.toList());

        return dispatchConverter.convertDispatchLoadToDispatchLoadResponseDTO(dispatchLoad, droneResponseDTO, medicationLoadResponseDTOS);

    }
}
