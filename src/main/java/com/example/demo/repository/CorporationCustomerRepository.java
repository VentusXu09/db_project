package com.example.demo.repository;

import com.example.demo.domain.CorporationCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporationCustomerRepository extends JpaRepository<CorporationCustomer, Long> {
}
