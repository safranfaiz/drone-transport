package com.safran.dronetransport.controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.safran.dronetransport.agent.DroneAgent;
import com.safran.dronetransport.dto.DroneBatteryPercentageDTO;
import com.safran.dronetransport.dto.DroneRequestDTO;
import com.safran.dronetransport.dto.DroneResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drone")
public class DroneController {

    @Autowired
    DroneAgent droneAgent;

    @PostMapping
    public DroneResponseDTO createDrone(@RequestBody DroneRequestDTO droneRequestDTO) {
        return droneAgent.create(droneRequestDTO);
    }

    @GetMapping
    public List<DroneResponseDTO> getAllDrones() {
        return droneAgent.getAllDrones();
    }

    @PatchMapping("/{serialNumber}")
    public DroneResponseDTO patchDrone(@PathVariable("serialNumber") Long serialNumber, @RequestBody JsonPatch patch) {
        return droneAgent.updateDroneBattery(serialNumber, patch);
    }

    @GetMapping("/{serialNumber}")
    public DroneResponseDTO getDroneBySerialNumber(@PathVariable("serialNumber") Long serialNumber){
        return droneAgent.getDroneBySerialNumber(serialNumber);
    }

    @GetMapping("/{serialNumber}/battery")
    public DroneBatteryPercentageDTO getDroneBatteryPercentage(@PathVariable("serialNumber") Long serialNumber){
        return droneAgent.getDroneBatteryPercentage(serialNumber);
    }

    @GetMapping("/available")
    public List<DroneResponseDTO> getAvailableDroneForLoad(){
        return droneAgent.getAvailableDroneForLoad();
    }

}
