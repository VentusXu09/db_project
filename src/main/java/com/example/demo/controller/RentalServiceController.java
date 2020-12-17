package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.domain.RentalService;
import com.example.demo.domain.dto.RentalDto;
import com.example.demo.domain.support.RentalServiceId;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RentalServiceRepository;
import com.example.demo.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/rental")
public class RentalServiceController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentalServiceRepository rentalServiceRepository;

    @PostMapping("")
    public GenericResponse submitRental(@Valid RentalDto rentalDto) {


        Customer customer = customerRepository.findByEmail(rentalDto.getCustomerName());

        final RentalService rentalService = new RentalService();
        final RentalServiceId rentalServiceId = new RentalServiceId();
        rentalServiceId.setPickup(Long.valueOf(rentalDto.getPickupLocation()));
        rentalServiceId.setDropoff(Long.valueOf(rentalDto.getDropoffLocation()));
        rentalServiceId.setCustomer(Long.valueOf(customer.getId()));
        rentalServiceId.setVehicle(Long.valueOf(rentalDto.getVehicleId()));
        rentalServiceId.setPickup_date(ZonedDateTime.parse(rentalDto.getPickupDate()));
        rentalService.setRentalServiceid(rentalServiceId);

        rentalService.setDropoff_date(ZonedDateTime.parse(rentalDto.getDropoffDate()));
        rentalService.setDaily_limit(Double.valueOf(110));

        final RentalService saved = rentalServiceRepository.save(rentalService);

        return new GenericResponse("success");
    }
}
