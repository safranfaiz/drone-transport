package com.safran.dronetransport.repo;

import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    Optional<Drone> findBySerialNumber(Long serialNumber);

    List<Drone> findByDroneStateAndBatteryCapacityGreaterThan(DroneState droneState, int batteryCapacity);

}
