package com.safran.dronetransport.agent;

import com.github.fge.jsonpatch.JsonPatch;
import com.safran.dronetransport.convertor.DroneConverter;
import com.safran.dronetransport.dto.*;
import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.service.DroneService;
import com.safran.dronetransport.specification.DroneRequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DroneAgent {

    @Autowired
    private DroneService droneService;

    @Autowired
    private DroneConverter droneConverter;

    @Autowired
    private DroneRequestSpecification droneRequestSpecification;

    /**
     * Register drone to DB
     * @param droneRequestDTO
     * @return DroneResponseDTO
     */
    public DroneResponseDTO create(DroneRequestDTO droneRequestDTO) {
        droneRequestSpecification.validateCreateRequest(droneRequestDTO);
        Drone drone = droneConverter.convertToDrone(droneRequestDTO);
        return droneConverter.convertToDroneResponseDTO(droneService.createDrone(drone));
    }

    /**
     * Get all registered drone from DB
     * @return List<DroneResponseDTO>
     */
    public List<DroneResponseDTO> getAllDrones() {
        return droneConverter.convertListOfDroneToDroneResponseDTO(droneService.getAllDrones());
    }

    public DroneResponseDTO updateDroneBattery(long serialNumber, JsonPatch patch) {
        Drone drone = droneBySerialNumber(serialNumber);
        drone.setBatteryCapacity(droneRequestSpecification.applyPatchToDrone(patch,new Drone()).getBatteryCapacity());
        return droneConverter.convertToDroneResponseDTO(droneService.createDrone(drone));
    }

    public DroneResponseDTO getDroneBySerialNumber(long serialNumber){
        return droneConverter.convertToDroneResponseDTO(droneBySerialNumber(serialNumber));
    }

    public Drone droneBySerialNumber(long serialNumber){
       return droneService.getDroneBySerialNumber(serialNumber);
    }

    public List<DroneResponseDTO> getAvailableDroneForLoad(){
        return droneConverter.convertListOfDroneToDroneResponseDTO(droneService.getAvailableDrones());
    }

    public DroneBatteryPercentageDTO getDroneBatteryPercentage(long serialNumber){
        Drone drone = droneBySerialNumber(serialNumber);
        return droneConverter.convertDroneToDroneBatteryPercentageDTO(drone);
    }
}
