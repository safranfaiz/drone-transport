package com.safran.dronetransport.dto;

import lombok.Data;

import java.util.List;

@Data
public class LoadDispatcherDroneDTO {
    private long serialNumber;
    private List<LoadDispatcherMedicationDTO> loadDispatcherMedicationDTOs;
}
