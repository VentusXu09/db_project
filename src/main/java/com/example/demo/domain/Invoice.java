package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICE")
@Getter
@Setter
public class Invoice extends BaseModel{

    @Column(nullable = false)
    private ZonedDateTime invoice_date;

    @Column(nullable = false)
    private Double amount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", cascade = CascadeType.REMOVE)
    private List<Payment> payments = new ArrayList<>();
}
