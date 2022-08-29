package com.safran.dronetransport.controller;

import com.safran.dronetransport.agent.DispatchAgent;
import com.safran.dronetransport.dto.LoadDispatcherDroneDTO;
import com.safran.dronetransport.entity.DispatchLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dispatch")
public class DispatchController {

    @Autowired
    DispatchAgent dispatchAgent;

    @PostMapping("/{serialNumber}/load")
    public DispatchLoad loadDispatcher(@RequestBody LoadDispatcherDroneDTO dispatcherDroneDTO){
        return dispatchAgent.loadDispatchMedicine(dispatcherDroneDTO);
    }

    @GetMapping("")
    public List<DispatchLoad> test(){
        return dispatchAgent.loadDispatchDroneWithItems();
    }
}
