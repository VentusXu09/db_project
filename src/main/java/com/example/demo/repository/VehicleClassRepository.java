package com.example.demo.repository;

import com.example.demo.domain.VehicleClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleClassRepository extends JpaRepository<VehicleClass, Long> {
}
