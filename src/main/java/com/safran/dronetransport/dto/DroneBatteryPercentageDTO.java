package com.safran.dronetransport.dto;

import lombok.Data;

@Data
public class DroneBatteryPercentageDTO {
    private long serialNumber;
    private int batteryPercentage;
}
