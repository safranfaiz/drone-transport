package com.safran.dronetransport.controller;

import com.safran.dronetransport.agent.DispatchAgent;
import com.safran.dronetransport.dto.LoadDispatcherDroneDTO;
import com.safran.dronetransport.entity.DispatchLoad;
import com.safran.dronetransport.entity.MedicationLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("dispatch")
public class DispatchController {

    @Autowired
    DispatchAgent dispatchAgent;

    @PostMapping("/load")
    public DispatchLoad loadDispatcher(@Valid @RequestBody LoadDispatcherDroneDTO dispatcherDroneDTO){
        return dispatchAgent.loadDispatchMedicine(dispatcherDroneDTO);
    }

    @GetMapping("")
    public List<DispatchLoad> getAllDispatchLoad(){
        return dispatchAgent.loadDispatchDroneWithItems();
    }

    @GetMapping("/{serialNumber}")
    public List<MedicationLoad> getDispatchLoadBySerialNumber(@PathVariable Long serialNumber){
        return dispatchAgent.getDispatchLoadBySerialNumber(serialNumber).getMedicationLoads();
    }

}
