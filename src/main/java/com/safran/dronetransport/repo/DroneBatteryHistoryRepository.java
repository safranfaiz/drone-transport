package com.safran.dronetransport.repo;

import com.safran.dronetransport.entity.DroneBatteryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneBatteryHistoryRepository extends JpaRepository<DroneBatteryHistory, Long> {
}
