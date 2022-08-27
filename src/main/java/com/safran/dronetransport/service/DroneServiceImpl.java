package com.safran.dronetransport.service;

import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.repo.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
