package com.hmbrandt.maintenance_service.repository;

import com.hmbrandt.maintenance_service.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic,Long> {
    List<Mechanic> findByActiveTrue();

    Optional<Mechanic> findByIdAndActiveTrue(Long id);
}

