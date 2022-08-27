package com.safran.dronetransport.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Medication {

    @Id
    private UUID uuid;
    private String name;
    private long weight;
    private String code;
    private String image;
}
