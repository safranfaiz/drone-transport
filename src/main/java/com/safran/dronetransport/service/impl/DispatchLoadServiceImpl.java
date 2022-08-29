package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.entity.*;
import com.safran.dronetransport.repo.DispatchLoadRepository;
import com.safran.dronetransport.repo.MedicationLoadRepository;
import com.safran.dronetransport.service.DispatchLoadService;
import com.safran.dronetransport.service.DroneService;
import com.safran.dronetransport.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DispatchLoadServiceImpl implements DispatchLoadService {

    @Autowired
    DroneService droneService;

    @Autowired
    MedicationService medicationService;

    @Autowired
    DispatchLoadRepository dispatchLoadRepository;

    @Autowired
    MedicationLoadRepository medicationLoadRepository;

    @Override
    public DispatchLoad createDispatch(DispatchLoad dispatchLoad) {
        return dispatchLoadRepository.save(dispatchLoad);

    }

    public List<DispatchLoad> findAll(){
        return dispatchLoadRepository.findAll();
    }
}
