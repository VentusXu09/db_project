package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "OFFICE_LOCATION",
        indexes = @Index(name = "idx_off_location_add",
                columnList = "ofc_state, ofc_city, ofc_street_add",
                unique = false))
@Getter
@Setter
public class OfficeLocation extends BaseModel{

    @Column(nullable = false)
    private String ofc_street_add;

    @Column(nullable = false)
    private String ofc_city;

    @Column(nullable = false)
    private String ofc_state;

    @Column(nullable = false)
    private Integer ofc_zipcode;

    @Column(nullable = false)
    private Long ofc_number;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "officeLocation", cascade = CascadeType.REMOVE)
    private List<Vehicle> vehicles= new ArrayList<>();

    @OneToMany(mappedBy = "pickup")
    private Set<RentalService> pickup;

    @OneToMany(mappedBy = "dropoff")
    private Set<RentalService> dropoff;




    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getOfc_state())
                .append(", ")
                .append(this.getOfc_city())
                .append(", ")
                .append(this.getOfc_street_add());
        return stringBuilder.toString();
    }
}
