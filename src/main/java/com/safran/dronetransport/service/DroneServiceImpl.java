package com.safran.dronetransport.service;

import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneState;
import com.safran.dronetransport.repo.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Override
    public Drone createDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public List<Drone> getAllDrones(){
        return droneRepository.findAll();
    }

    @Override
    public Drone getDroneBySerialNumber(long serialNumber) {
//        droneRepository.fin
        return droneRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Drone findByUUID(UUID uuid) {
        return droneRepository.findById(uuid).get();
    }

    @Override
    public void updateDroneBatteryPercentageBySerialNumber(int batteryPercentage,long serialNumber) {
        droneRepository.updateDroneBatteryPercentageBySerialNumber(batteryPercentage, serialNumber);
    }

    @Override
    public List<Drone> getAvailableDrones() {
        return droneRepository.findByDroneState(DroneState.IDLE);
    }


}
