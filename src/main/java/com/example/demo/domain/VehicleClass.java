package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VehicleClass")
@Getter
@Setter
public class VehicleClass extends BaseModel {

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "charge_r", nullable = false)
    private Double rent_charge;

    @Column(name = "charge_e", nullable = false)
    private Double extra_charge;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleClass", cascade = CascadeType.REMOVE)
    private List<Vehicle> vehicles = new ArrayList<>();
}
