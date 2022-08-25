package com.safran.dronetransport.convertor;

import com.safran.dronetransport.dto.DroneRequestDTO;
import com.safran.dronetransport.dto.DroneResponseDTO;
import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneState;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DroneConverter {

    public Drone convertToDrone(DroneRequestDTO droneRequestDTO){
        Drone drone = new Drone();
        drone.setUuid(UUID.randomUUID());
        drone.setDroneState(DroneState.IDLE);
        drone.setSerialNumber(droneRequestDTO.getSerialNumber());
        drone.setModel(droneRequestDTO.getModel());
        drone.setBatteryCapacity(0);
        drone.setWeight(droneRequestDTO.getWeight());

        return drone;
    }

    public DroneResponseDTO convertToDroneResponseDTO(Drone drone){
        DroneResponseDTO droneResponseDTO = new DroneResponseDTO();
        droneResponseDTO.setSerialNumber(drone.getSerialNumber());
        droneResponseDTO.setBatteryCapacity(drone.getBatteryCapacity());
        droneResponseDTO.setModel(drone.getModel());
        droneResponseDTO.setWeight(drone.getWeight());

        return droneResponseDTO;
    }
}
