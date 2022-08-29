package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.entity.Medication;
import com.safran.dronetransport.repo.MedicationRepository;
import com.safran.dronetransport.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    MedicationRepository medicationRepository;

    @Override
    public Medication createMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public Medication findByMedicationCode(String code) {
        return medicationRepository.findByCode(code).orElseThrow(() ->
                new RuntimeException("Cannot find medication by this code: "+code));

    }
}
