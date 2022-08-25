package com.safran.dronetransport.agent;

import com.safran.dronetransport.convertor.DroneConverter;
import com.safran.dronetransport.dto.DroneRequestDTO;
import com.safran.dronetransport.dto.DroneResponseDTO;
import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.service.DroneService;
import com.safran.dronetransport.specification.DroneRequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DroneAgent {

    @Autowired
    private DroneService droneService;

    @Autowired
    private DroneConverter droneConverter;

    @Autowired
    private DroneRequestSpecification droneRequestSpecification;

    public DroneResponseDTO create(DroneRequestDTO droneRequestDTO){
        droneRequestSpecification.validateCreateRequest(droneRequestDTO);
       Drone drone = droneConverter.convertToDrone(droneRequestDTO);
       return droneConverter.convertToDroneResponseDTO(droneService.createDrone(drone));
    }
}
