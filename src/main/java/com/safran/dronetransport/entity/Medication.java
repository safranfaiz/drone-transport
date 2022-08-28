package com.safran.dronetransport.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uuid;
    private String name;
    private long weight;
    private String code;
    private String image;
}
