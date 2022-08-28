package com.safran.dronetransport.dto;

import com.safran.dronetransport.entity.DroneModel;
import com.safran.dronetransport.entity.DroneState;
import lombok.Data;

@Data
public class DroneResponseDTO {

    private long serialNumber;
    private DroneModel model;
    private long weight;
    private int batteryCapacity;
    private DroneState droneState;

}
