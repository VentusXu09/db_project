package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COUPONS")
@Getter
@Setter
public class Coupon extends BaseModel{
    private static final SimpleDateFormat SLUG_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    @Column(nullable = false)
    private Long discount;

    @Column(nullable = false)
    private ZonedDateTime valid_from;

    @Column(nullable = false)
    private ZonedDateTime valid_to;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="COUPON_CUSTOMER",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "coupon_id")})
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "coupon")
    private Set<RentalService> rentalServices;

}
