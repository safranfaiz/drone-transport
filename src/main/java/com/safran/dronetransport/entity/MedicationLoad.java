package com.safran.dronetransport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class MedicationLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Medication medication;

    private long qty;
    private long total;

    @ManyToOne
    @JsonIgnore
    private DispatchLoad dispatchLoad;

}
