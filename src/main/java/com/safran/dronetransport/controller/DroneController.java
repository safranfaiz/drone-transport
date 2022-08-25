package com.safran.dronetransport.controller;

import com.safran.dronetransport.agent.DroneAgent;
import com.safran.dronetransport.dto.DroneRequestDTO;
import com.safran.dronetransport.dto.DroneResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("drone")
public class DroneController {

    @Autowired
    DroneAgent droneAgent;

    @PostMapping("/")
    public DroneResponseDTO createDrone(@RequestBody DroneRequestDTO droneRequestDTO){
        return droneAgent.create(droneRequestDTO);
    }
}
