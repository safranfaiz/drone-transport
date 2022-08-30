package com.safran.dronetransport.dto;

import com.safran.dronetransport.entity.DroneModel;
import com.safran.dronetransport.entity.DroneState;
import lombok.Data;

@Data
public class DroneResponseDTO {

    private Long serialNumber;
    private DroneModel model;
    private Long weight;
    private Integer batteryCapacity;
    private DroneState droneState;

}
