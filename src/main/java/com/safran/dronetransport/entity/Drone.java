package com.safran.dronetransport.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Drone {

    @Id
    private UUID uuid;
    @Column(nullable = false,length = 100)
    private long serialNumber;
    @Column(nullable = false)
    @Enumerated
    private DroneModel model;
    @Column(nullable = false)
    private long weight;
    @Column(nullable = false)
    private int batteryCapacity;
    @Column(nullable = false)
    @Enumerated
    private DroneState droneState;

}
