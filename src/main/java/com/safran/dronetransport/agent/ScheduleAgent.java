package com.safran.dronetransport.agent;

import com.safran.dronetransport.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleAgent {

    @Autowired
    DroneService droneService;

    @Scheduled(cron = " 0/5 * * * * ?")
    public void cronJob(){
        if (droneService.getAllDrones() != null){
            droneService.getAllDrones().stream().forEach(drone -> System.out.println(drone.toString()));
            System.out.println("");
        }
    }
}
