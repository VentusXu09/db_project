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
public class RentalService extends BaseModel{
    @EmbeddedId
    private RentalServiceId rentalServiceid;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "pickup_location", referencedColumnName = "id", nullable = false)
    private OfficeLocation pickup;

    @ManyToOne
    @JoinColumn(name = "dropoff_location", referencedColumnName = "id", nullable = false)
    private OfficeLocation dropoff;

    @Column(nullable = true)
    private Double start_odometer;

    @Column(nullable = true)
    private Double end_odometer;

    @Column(nullable = false)
    private Double daily_limit;

    @Column(nullable = false)
    private ZonedDateTime dropoff_date;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = true)
    private Coupon coupon;


}
