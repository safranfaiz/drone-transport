package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneState;
import com.safran.dronetransport.repo.DroneRepository;
import com.safran.dronetransport.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Value("${drone.transport.battery.percentage.min}")
    int batteryCapacity;

    @Override
    public Drone createDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    @Override
    public Drone getDroneBySerialNumber(long serialNumber) {
        return droneRepository.findBySerialNumber(serialNumber).orElseThrow( () ->
            new RuntimeException("Cannot find Drone by this serial number: " + serialNumber)
        );
    }

    @Override
    public Drone findByUUID(UUID uuid) {
        return droneRepository.findById(uuid).get();
    }

    @Override
    public void updateDroneBatteryPercentageBySerialNumber(int batteryPercentage, long serialNumber) {
        droneRepository.updateDroneBatteryPercentageBySerialNumber(batteryPercentage, serialNumber);
    }

    @Override
    public List<Drone> getAvailableDrones() {
        return droneRepository.findByDroneStateAndBatteryCapacityGreaterThan(DroneState.IDLE, batteryCapacity);
    }

    @Override
    public Drone changeDroneState(Drone drone) {
        return createDrone(drone);
    }

}
