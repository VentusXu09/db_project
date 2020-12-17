package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
public class Vehicle extends BaseModel{

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private Long vin;

    @Column(name = "license_no", nullable = false)
    private String license_plate_no;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private VehicleClass vehicleClass;

    @ManyToOne()
    @JoinColumn(name = "loc_id", nullable = false)
    private OfficeLocation officeLocation;

    @OneToMany(mappedBy = "vehicle")
    private Set<RentalService> rentalServices;

}
