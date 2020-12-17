package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Invoice;
import com.example.demo.domain.RentalService;
import com.example.demo.domain.dto.RentalDto;
import com.example.demo.domain.support.RentalServiceId;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.RentalServiceRepository;
import com.example.demo.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/rental")
public class RentalServiceController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentalServiceRepository rentalServiceRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @PostMapping("")
    public GenericResponse submitRental(@Valid RentalDto rentalDto) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");

        Customer customer = customerRepository.findByEmail(rentalDto.getCustomerName());

        final Invoice invoice = new Invoice();
        invoice.setInvoice_date(ZonedDateTime.now());
        invoice.setAmount(Double.valueOf(0));
        final Invoice savedInvoice = invoiceRepository.save(invoice);

        final RentalService rentalService = new RentalService();
        final RentalServiceId rentalServiceId = new RentalServiceId();
        rentalServiceId.setPickup(Long.valueOf(rentalDto.getPickupLocation()));
        rentalServiceId.setDropoff(Long.valueOf(rentalDto.getPickupLocation()));
        rentalServiceId.setCustomer(Long.valueOf(customer.getId()));
        rentalServiceId.setVehicle(Long.valueOf(rentalDto.getVehicleId()));
        rentalServiceId.setPickup_date(ZonedDateTime.now());
        rentalService.setRentalServiceid(rentalServiceId);

        rentalService.setDropoff_date(ZonedDateTime.now());
        rentalService.setDaily_limit(Double.valueOf(110));
        rentalService.setInvoice(savedInvoice);
        rentalService.setStart_odometer(Double.valueOf(0));
        rentalService.setEnd_odometer(Double.valueOf(0));

        final RentalService saved = rentalServiceRepository.save(rentalService);




        return new GenericResponse("success#" + savedInvoice.getId().toString());
    }
}
