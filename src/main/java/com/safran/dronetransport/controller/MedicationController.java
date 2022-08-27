package com.safran.dronetransport.controller;

import com.safran.dronetransport.entity.Medication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medication")
public class MedicationController {

    public Medication createMedication(Medication medication){

        return null;
    }
}
