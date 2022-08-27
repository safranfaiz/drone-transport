package com.safran.dronetransport.specification;

import com.safran.dronetransport.dto.MedicationDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class MedicationRequestSpecification {

    public void validateRequest(MedicationDTO medicationDTO){
        if(!Pattern.matches("^[a-zA-Z0-9_-]*$",medicationDTO.getName()))
            throw new RuntimeException("Medication NAME is not match");

        if(!Pattern.matches("^[A-Z0-9_]*$",medicationDTO.getCode()))
            throw new RuntimeException("Medication CODE is not match");

    }
}
