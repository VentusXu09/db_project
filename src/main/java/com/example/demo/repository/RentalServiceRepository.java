package com.example.demo.repository;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Invoice;
import com.example.demo.domain.RentalService;
import com.example.demo.domain.support.RentalServiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalServiceRepository extends JpaRepository<RentalService, RentalServiceId> {
    RentalService getRentalServiceByInvoiceEquals(Invoice invoice);

    RentalService findFirstByCustomer(Customer customer);

    @Query(value = "SELECT customerId from public.rental_service where id=:id", nativeQuery = true)
    String findCustomerId(@Param("id") Long id);
}
