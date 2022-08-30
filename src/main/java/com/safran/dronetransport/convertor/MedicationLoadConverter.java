package com.safran.dronetransport.convertor;

import com.safran.dronetransport.dto.MedicationDTO;
import com.safran.dronetransport.dto.MedicationLoadResponseDTO;
import com.safran.dronetransport.entity.MedicationLoad;
import org.springframework.stereotype.Component;

@Component
public class MedicationLoadConverter {

    public MedicationLoadResponseDTO convertToMedicationLoadResponse(MedicationLoad medicationLoad){
        MedicationLoadResponseDTO medicationLoadResponseDTO = new MedicationLoadResponseDTO();

        MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setName(medicationLoad.getMedication().getName());
        medicationDTO.setCode(medicationLoad.getMedication().getCode());
        medicationDTO.setWeight(medicationLoad.getMedication().getWeight());
        medicationDTO.setImage(medicationLoad.getMedication().getImage());

        medicationLoadResponseDTO.setQty(medicationLoad.getQty());
        medicationLoadResponseDTO.setTotal(medicationLoad.getTotal());
        medicationLoadResponseDTO.setMedication(medicationDTO);
        return  medicationLoadResponseDTO;
    }
}
