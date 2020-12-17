package com.example.demo.domain.support;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Embeddable
@Getter
@Setter
public class RentalServiceId implements Serializable {
    @Column(name = "pickup_date")
    private ZonedDateTime pickup_date;

    @Column(name = "vehicle_id")
    private Long vehicle;

    @Column(name = "customer_id")
    private Long customer;

    @Column(name = "pickup_location")
    private Long pickup;

    @Column(name = "dropoff_location")
    private Long dropoff;

    public RentalServiceId() {

    }

    public RentalServiceId(ZonedDateTime pickup_date, Long vehicle, Long customer, Long pickup, Long dropoff) {
        this.pickup_date = pickup_date;
        this.vehicle = vehicle;
        this.customer = customer;
        this.pickup = pickup;
        this.dropoff = dropoff;
    }
}
