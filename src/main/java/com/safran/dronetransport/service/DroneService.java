package com.safran.dronetransport.service;

import com.safran.dronetransport.entity.Drone;

import java.util.List;

public interface DroneService {
    Drone createDrone(Drone drone);

    List<Drone> getAllDrones();
}
