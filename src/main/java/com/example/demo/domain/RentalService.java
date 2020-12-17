package com.example.demo.domain;

import com.example.demo.domain.support.RentalServiceId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "RENTAL_SERVICE")
@Getter
@Setter
public class RentalService{
    @EmbeddedId
    private RentalServiceId rentalServiceid;

    @ManyToOne
    @MapsId("vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @MapsId("customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("pickup_location")
    private OfficeLocation pickup;

    @ManyToOne
    @MapsId("dropoff_location")
    private OfficeLocation dropoff;

    @Column(nullable = true)
    private Double start_odometer;

    @Column(nullable = true)
    private Double end_odometer;

    @Column(nullable = false)
    private Double daily_limit;

    @Column(nullable = false, name = "dropoff_date")
    private ZonedDateTime dropoff_date;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = true)
    private Coupon coupon;


}
