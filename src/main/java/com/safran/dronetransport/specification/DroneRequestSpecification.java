package com.safran.dronetransport.specification;

import com.safran.dronetransport.dto.DroneRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class DroneRequestSpecification {

    public void validateCreateRequest(DroneRequestDTO requestDTO){
        if(requestDTO.getWeight() <= 0 || requestDTO.getWeight() > 500){
            throw new RuntimeException("Your drone is over weight");
        }
    }
}
