package com.safran.dronetransport.convertor;

import com.safran.dronetransport.dto.MedicationDTO;
import com.safran.dronetransport.entity.Medication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicationConverter {

    public Medication convertToMedication(MedicationDTO medicationDTO){
        Medication medication = new Medication();
        medication.setUuid(UUID.randomUUID());
        medication.setName(medicationDTO.getName());
        medication.setWeight(medicationDTO.getWeight());
        medication.setCode(medicationDTO.getCode());
        medication.setImage(medicationDTO.getImage());
        return medication;
    }

    public MedicationDTO convertMedicationResponseDTO(Medication medication){
        MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setName(medication.getName());
        medicationDTO.setCode(medication.getCode());
        medicationDTO.setWeight(medication.getWeight());
        medicationDTO.setImage(medication.getImage());

        return medicationDTO;
    }
}
