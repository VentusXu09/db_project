package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "INDIVIDUAL_CUST")
@DiscriminatorValue("I")
@Getter
@Setter
public class IndividualCustomer extends Customer {

    @Column(nullable = true)
    private String driver_licence_no;

    @Column(nullable = true)
    private String insurance_company;

    @Column(nullable = true)
    private String insurance_policy_no;

    public IndividualCustomer(Customer customer) {
        super(customer.getFirst_name(),customer.getLast_name(),
                customer.getEmail(), customer.getPhone_no(), customer.getAddress(),
                customer.getPassword(), customer.getCoupons());

    }

    public IndividualCustomer() {

    }
}
