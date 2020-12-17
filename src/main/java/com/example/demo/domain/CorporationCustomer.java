package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CORPORATION_CUST")
@DiscriminatorValue("C")
@Getter
@Setter
public class CorporationCustomer extends Customer {

    @Column(nullable = true)
    private Long employee_id;

    @ManyToOne
    @JoinColumn(name = "corporation_id", nullable = true)
    private Corporation corporation;

    public CorporationCustomer() {
        super();
    }

    public CorporationCustomer(Customer customer) {
        super(customer.getFirst_name(),customer.getLast_name(),
                customer.getEmail(), customer.getPhone_no(), customer.getAddress(),
                customer.getPassword(), customer.getCoupons());
    }
}
