package com.safran.dronetransport.repo;

import com.safran.dronetransport.entity.DispatchLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatchLoadRepository extends JpaRepository<DispatchLoad, Long> {
    DispatchLoad findByDrone_SerialNumber(Long serialNumber);
}
