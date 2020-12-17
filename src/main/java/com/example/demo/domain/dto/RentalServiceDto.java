package com.example.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalServiceDto {
    private String dropoff_location;

    private String pickup_location;

    private String vehicle_id;

    private String customer_id;
}
