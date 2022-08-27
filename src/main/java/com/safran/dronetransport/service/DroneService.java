package com.safran.dronetransport.service;

import com.safran.dronetransport.entity.Drone;

import java.util.List;
import java.util.UUID;

public interface DroneService {
    Drone createDrone(Drone drone);

    List<Drone> getAllDrones();

    Drone getDroneBySerialNumber(long serialNumber);

    Drone findByUUID(UUID uuid);

    void updateDroneBatteryPercentageBySerialNumber(int batteryPercentage,long serialNumber);
}
