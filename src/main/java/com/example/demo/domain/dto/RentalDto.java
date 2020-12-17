package com.example.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalDto {
    private String pickupDate;

    private String dropoffDate;

    private String vehicleId;

    private String customerName;

    private String pickupLocation;

    private String dropoffLocation;
}
