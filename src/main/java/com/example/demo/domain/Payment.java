package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "PAYMENT")
@Getter
@Setter
public class Payment extends BaseModel{


    @Column(nullable = false)
    private String pay_method;

    @Column(nullable = false)
    private Long card_num;

    @Column(nullable = false)
    private Double pay_amount;

    @Column(nullable = false)
    private ZonedDateTime pay_date;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;
}
