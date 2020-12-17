package com.example.demo.repository;

import com.example.demo.domain.RentalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RentalServiceRepository extends JpaRepository<RentalService, Long> {
    RentalService getRentalServiceByInvoiceEquals(Long id);

    RentalService findByCustomer(@Param("id") Long id);
}
