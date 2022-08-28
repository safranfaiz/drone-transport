package com.safran.dronetransport.repo;

import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface DroneRepository extends JpaRepository<Drone, UUID> {
    Drone findBySerialNumber(long serialNumber);

    @Transactional
    @Modifying
    @Query("update Drone set batteryCapacity=?1 where serialNumber=?2")
    void updateDroneBatteryPercentageBySerialNumber(int batteryPercentage,long serialNumber);

    List<Drone> findByDroneState(DroneState droneState);
}
