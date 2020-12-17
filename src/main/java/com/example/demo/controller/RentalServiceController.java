package com.example.demo.controller;

import com.example.demo.domain.dto.VehicleDto;
import com.example.demo.utils.GenericResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rental")
public class RentalServiceController {

    @PostMapping("")
    public GenericResponse submitRental(@Valid VehicleDto vehicleDto) {

        return new GenericResponse("success");
    }
}
