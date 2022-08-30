package com.safran.dronetransport.dto;

import lombok.Data;

@Data
public class MedicationLoadResponseDTO {

    private MedicationDTO medication;
    private Long qty;
    private Long total;

}
