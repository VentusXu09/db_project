package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="customer_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("I")
@Getter
@Setter
public class Customer extends BaseModel{
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false, unique = true)
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

    public Customer(String first_name, String last_name, String email, Long phone_no, Address address, String password, Set<Coupon> coupons) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_no = phone_no;
        this.address = address;
        this.password = password;
        this.coupons = coupons;
    }

    public Customer() {

    }
}
