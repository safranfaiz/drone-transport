package com.safran.dronetransport.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
