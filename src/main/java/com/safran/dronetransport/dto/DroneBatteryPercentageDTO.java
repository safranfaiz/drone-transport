package com.safran.dronetransport.dto;

import lombok.Data;

@Data
public class DroneBatteryPercentageDTO {
    private Long serialNumber;
    private int batteryPercentage;
}
