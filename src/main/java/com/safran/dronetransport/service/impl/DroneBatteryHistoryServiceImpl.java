package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.entity.DroneBatteryHistory;
import com.safran.dronetransport.repo.DroneBatteryHistoryRepository;
import com.safran.dronetransport.service.DroneBatteryHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneBatteryHistoryServiceImpl implements DroneBatteryHistoryService {

    @Autowired
    DroneBatteryHistoryRepository droneBatteryHistoryRepository;

    @Override
    public DroneBatteryHistory createDroneBatteryHistory(DroneBatteryHistory droneBatteryHistory) {
        return droneBatteryHistoryRepository.save(droneBatteryHistory);
    }
}
