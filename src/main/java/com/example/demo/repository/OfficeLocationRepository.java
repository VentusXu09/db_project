package com.example.demo.repository;

import com.example.demo.domain.OfficeLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeLocationRepository extends JpaRepository<OfficeLocation, Long> {
}
