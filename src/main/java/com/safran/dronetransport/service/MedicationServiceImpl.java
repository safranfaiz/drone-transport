package com.safran.dronetransport.service;

import com.safran.dronetransport.entity.Medication;
import com.safran.dronetransport.repo.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationServiceImpl implements MedicationService{

    @Autowired
    MedicationRepository medicationRepository;

    @Override
    public Medication createMedication(Medication medication) {
        return medicationRepository.save(medication);
    }
}
