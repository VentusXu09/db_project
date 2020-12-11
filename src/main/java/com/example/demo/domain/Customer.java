package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="customer_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public class Customer extends BaseModel{

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;

    @Column(precision = 10, nullable = false)
    private Long phone_no;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @JsonIgnore
    private String password;

    @ManyToMany(mappedBy = "customers")
    private Set<Coupon> coupons = new HashSet<>();
}
