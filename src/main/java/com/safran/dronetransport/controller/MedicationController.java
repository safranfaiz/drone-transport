package com.safran.dronetransport.controller;

import com.safran.dronetransport.agent.MedicationAgent;
import com.safran.dronetransport.dto.MedicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medication")
public class MedicationController {

    @Autowired
    MedicationAgent medicationAgent;

    @PostMapping
    public MedicationDTO createMedication(@RequestBody MedicationDTO medicationDTO){
        return medicationAgent.create(medicationDTO);
    }
}
