package com.safran.dronetransport.agent;

import com.safran.dronetransport.convertor.DroneConverter;
import com.safran.dronetransport.dto.DroneRequestDTO;
import com.safran.dronetransport.dto.DroneResponseDTO;
import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.service.DroneService;
import com.safran.dronetransport.specification.DroneRequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Drone> droneList = droneService.getAllDrones();
        return droneList.stream().map(drone -> {
            DroneResponseDTO droneResponseDTO = new DroneResponseDTO();
            droneResponseDTO.setSerialNumber(drone.getSerialNumber());
            droneResponseDTO.setModel(drone.getModel());
            droneResponseDTO.setBatteryCapacity(drone.getBatteryCapacity());
            droneResponseDTO.setWeight(drone.getWeight());
            return droneResponseDTO;
        }).collect(Collectors.toList());
    }
}
