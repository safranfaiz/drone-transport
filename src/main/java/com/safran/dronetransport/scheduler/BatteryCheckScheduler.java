package com.safran.dronetransport.scheduler;

import com.safran.dronetransport.convertor.DroneBatteryHistoryConverter;
import com.safran.dronetransport.entity.LogType;
import com.safran.dronetransport.service.DroneBatteryHistoryService;
import com.safran.dronetransport.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BatteryCheckScheduler {

    @Autowired
    DroneService droneService;

    @Autowired
    DroneBatteryHistoryService droneBatteryHistoryService;

    @Autowired
    DroneBatteryHistoryConverter droneBatteryHistoryConverter;

    @Value("${drone.transport.battery.check.schedule.logging}")
    String logType;

    /**
     * If type is FILE then logs save to log/battery-history.log
     * If type is DB then saved to the DroneBatteryHistory table
     */
    @Scheduled(cron = "${drone.transport.battery.check.schedule}")
    public void batteryLevelCheckProcessor() {
        log.debug("Battery Level check schedule executing...");
        droneService.getAllDrones().stream().forEach(drone -> {

            if (LogType.FILE.name().equals(logType)) {
                log.info("Drone with ID {} Serial Number {} Identify with battery level {}",
                        drone.getId(), drone.getSerialNumber(), drone.getBatteryCapacity());
            } else {
                droneBatteryHistoryService.createDroneBatteryHistory(
                        droneBatteryHistoryConverter.covertDroneToDroneBatteryHistory(drone));
            }
        });
    }
}
