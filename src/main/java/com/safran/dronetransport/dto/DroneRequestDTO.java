package com.safran.dronetransport.dto;

import com.safran.dronetransport.entity.DroneModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DroneRequestDTO {

    @NotNull(message = "Serial Number cannot null")
    private Long serialNumber;
    private DroneModel model;
    private Long weight;

}
