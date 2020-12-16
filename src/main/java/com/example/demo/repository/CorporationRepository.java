package com.example.demo.repository;

import com.example.demo.domain.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporationRepository extends JpaRepository<Corporation, Long> {
}
