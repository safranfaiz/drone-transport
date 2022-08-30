package com.safran.dronetransport.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LoadDispatcherDroneDTO {

    @NotNull(message = "Serial Number is required")
    private Long serialNumber;
    @NotEmpty(message = "At least one medication should be loaded")
    private List<LoadDispatcherMedicationDTO> loadDispatcherMedicationDTOs;
}
