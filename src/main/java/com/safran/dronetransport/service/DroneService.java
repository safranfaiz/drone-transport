package com.safran.dronetransport.service;

import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneState;

import java.util.List;

public interface DroneService {
    Drone createDrone(Drone drone);

    List<Drone> getAllDrones();

    Drone getDroneBySerialNumber(Long serialNumber);

    List<Drone> getAvailableDrones();

    Drone changeDroneState(Drone drone, DroneState droneState);
}
