package com.safran.dronetransport.dto;

import lombok.Data;

import java.util.List;

@Data
public class DispatchLoadResponseDTO {

    private Long id;
    private DroneResponseDTO drone;
    private Long totalWeight;
    private List<MedicationLoadResponseDTO> medicationLoad;

}
