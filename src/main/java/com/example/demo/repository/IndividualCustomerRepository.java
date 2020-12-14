package com.example.demo.repository;

import com.example.demo.domain.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {
}
