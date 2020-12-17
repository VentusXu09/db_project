package com.example.demo.controller;

import com.example.demo.domain.Invoice;
import com.example.demo.domain.Payment;
import com.example.demo.domain.RentalService;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.RentalServiceRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("invoices")
public class InvoiceController{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private RentalServiceRepository rentalServiceRepository;

    @GetMapping
    @RequestMapping("/{id}")
    public String getInvoiceDetails(@PathVariable(value = "id") String invoiceId) {
        Invoice invoice  = invoiceRepository.findOneById(Long.valueOf(invoiceId));
        RentalService service = rentalServiceRepository.getRentalServiceByInvoiceEquals(invoice);

        Map<String, String> map = new HashMap<>();

        Payment payment = null;
        if (invoice.getPayments() == null || invoice.getPayments().size() == 0) {
            map.put("pay_method", " ");
            map.put("pay_date", " ");
            map.put("card_num", "");
        } else {
            payment = invoice.getPayments().get(0);
            map.put("pay_method", payment.getPay_method());
            map.put("pay_date", payment.getPay_date().toString());
            map.put("card_num", String.valueOf(payment.getCard_num()));
        }

        map.put("id", invoiceId);
        map.put("start_odometer", service.getStart_odometer().toString());
        map.put("end_odometer", service.getEnd_odometer().toString());
        map.put("amount", String.valueOf(invoice.getAmount()));
        map.put("pickup_loc", service.getPickup().toString());
        map.put("dropoff_loc", service.getDropoff().toString());
        map.put("pickup_date", service.getRentalServiceid().getPickup_date().toString());
        map.put("dropoff_date", service.getDropoff_date().toString());

        String json = new Gson().toJson(map);

        return json;
    }
}
