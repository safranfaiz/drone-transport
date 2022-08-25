package com.safran.dronetransport.service;

import com.safran.dronetransport.dto.DroneRequestDTO;
import com.safran.dronetransport.dto.DroneResponseDTO;
import com.safran.dronetransport.entity.Drone;

public interface DroneService {
    Drone createDrone(Drone drone);
}
