package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.constant.ErrorMessage;
import com.safran.dronetransport.entity.Medication;
import com.safran.dronetransport.exception.ResourceNotFoundException;
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
                new ResourceNotFoundException(ErrorMessage.Medication.MEDICATION_NOT_FOUND + code));

    }
}
