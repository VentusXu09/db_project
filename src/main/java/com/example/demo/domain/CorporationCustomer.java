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

    @Column(nullable = false)
    private Long employee_id;

    @ManyToOne
    @JoinColumn(name = "corporation_id", nullable = false)
    private Corporation corporation;
}
