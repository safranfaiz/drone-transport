package com.safran.dronetransport.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoadDispatcherMedicationDTO {

    @NotNull(message = "Code Cannot be Null")
    private String code;
    @NotNull
    private Long qty;

}
