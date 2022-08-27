package com.safran.dronetransport.agent;

import com.safran.dronetransport.convertor.MedicationConverter;
import com.safran.dronetransport.dto.MedicationDTO;
import com.safran.dronetransport.entity.Medication;
import com.safran.dronetransport.service.MedicationService;
import com.safran.dronetransport.specification.MedicationRequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicationAgent {

    @Autowired
    MedicationRequestSpecification medicationRequestSpecification;

    @Autowired
    MedicationConverter medicationConverter;

    @Autowired
    MedicationService medicationService;

    public MedicationDTO create(MedicationDTO medicationDTO){
        medicationRequestSpecification.validateRequest(medicationDTO);
        Medication medication = medicationConverter.convertToMedication(medicationDTO);
        return medicationConverter.convertMedicationResponseDTO(medicationService.createMedication(medication));
    }


}
