package com.safran.dronetransport.convertor;

import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneBatteryHistory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class DroneBatteryHistoryConverter{

    public DroneBatteryHistory covertDroneToDroneBatteryHistory(Drone drone){
        DroneBatteryHistory droneBatteryHistory = new DroneBatteryHistory();
        droneBatteryHistory.setDroneId(droneBatteryHistory.getDroneId());
        droneBatteryHistory.setBatteryCapacity(drone.getBatteryCapacity());
        droneBatteryHistory.setTimestamp(Timestamp.from(Instant.now()));

        return droneBatteryHistory;
    }
}
