package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.domain.dto.PaymentDto;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.RentalServiceRepository;
import com.example.demo.utils.GenericResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private RentalServiceRepository rentalServiceRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/{id}")
    public String getPaymentDetail(@PathVariable("id") String id) {
        Random r = new Random();
        Double rangeMin = Double.valueOf(30);
        Double rangeMax = Double.valueOf(60);

        Customer customer = customerRepository.findByEmail(id);

        RentalService rentalService = rentalServiceRepository.findFirstByCustomer(customer);
        Vehicle vehicle = rentalService.getVehicle();
        VehicleClass type = vehicle.getVehicleClass();
        Invoice invoice = rentalService.getInvoice();

        Double start = rangeMin - (rangeMax - rangeMin) * r.nextDouble();
        Double end = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        rentalService.setStart_odometer(start);
        rentalService.setEnd_odometer(end);

        Double amount = (end - start) *  type.getRent_charge();
        invoice.setAmount(amount);

        invoiceRepository.save(invoice);

        Map<String, String> map = new HashMap<>();
        map.put("amount", String.valueOf(amount));

        String res = new Gson().toJson(map);

        return res;
    }

    @PostMapping()
    public GenericResponse submitPaymentDetail(@Valid PaymentDto paymentDto) {
        Customer customer = customerRepository.findByEmail(paymentDto.getCustomerName());
        RentalService rentalService = rentalServiceRepository.findFirstByCustomer(customer);
        Invoice invoice = rentalService.getInvoice();
        final Payment payment = new Payment();
        payment.setPay_amount(invoice.getAmount());
        payment.setCard_num(Long.valueOf(paymentDto.getCardNum()));
        payment.setPay_date(ZonedDateTime.now());
        payment.setPay_method(paymentDto.getPayMethod());
        payment.setInvoice(invoice);

        final Payment saved = paymentRepository.save(payment);

        return new GenericResponse("success#"+invoice.getId());
    }
}
