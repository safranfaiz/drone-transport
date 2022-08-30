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
    private Long id;
    @Column(nullable = false,length = 100, unique = true)
    private Long serialNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneModel model;
    @Column(nullable = false)
    private Long weight;
    @Column(nullable = false)
    private Integer batteryCapacity;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneState droneState;

}
