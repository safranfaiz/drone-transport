package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.entity.MedicationLoad;
import com.safran.dronetransport.repo.MedicationLoadRepository;
import com.safran.dronetransport.service.MedicationLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationLoadServiceImpl implements MedicationLoadService {

    @Autowired
    MedicationLoadRepository medicationLoadRepository;

    @Override
    public MedicationLoad createMedicationLoad(MedicationLoad medicationLoad) {
        return medicationLoadRepository.save(medicationLoad);
    }
}
