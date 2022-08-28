package com.safran.dronetransport.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class DispatchLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Drone drone;
    @OneToMany(mappedBy = "dispatchLoad", cascade = CascadeType.ALL)
    private List<MedicationLoad> medicationLoads;
}
