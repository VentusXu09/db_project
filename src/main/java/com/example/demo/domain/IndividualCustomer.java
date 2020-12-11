package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "INDIVIDUAL_CUST")
@DiscriminatorValue("I")
@Getter
@Setter
public class IndividualCustomer extends Customer {

    @Column(nullable = false)
    private String driver_licence_no;

    @Column(nullable = false)
    private String insurance_company;

    @Column(nullable = false)
    private String insurance_policy_no;

}
