package com.safran.dronetransport.repo;

import com.safran.dronetransport.entity.MedicationLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationLoadRepository extends JpaRepository<MedicationLoad, Long> {
}
