package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
}
