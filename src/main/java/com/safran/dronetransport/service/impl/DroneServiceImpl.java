package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.constant.ErrorMessage;
import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneState;
import com.safran.dronetransport.repo.DroneRepository;
import com.safran.dronetransport.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Value("${drone.transport.battery.percentage.min}")
    Integer batteryCapacity;

    @Override
    public Drone createDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    @Override
    public Drone getDroneBySerialNumber(Long serialNumber) {
        return droneRepository.findBySerialNumber(serialNumber).orElseThrow( () ->
            new RuntimeException(ErrorMessage.Drone.DRONE_NOT_FOUND + serialNumber)
        );
    }

    @Override
    public List<Drone> getAvailableDrones() {
        return droneRepository.findByDroneStateAndBatteryCapacityGreaterThan(DroneState.IDLE, batteryCapacity);
    }

    @Override
    public Drone changeDroneState(Drone drone, DroneState droneState) {
        drone.setDroneState(droneState);
        return createDrone(drone);
    }

}
