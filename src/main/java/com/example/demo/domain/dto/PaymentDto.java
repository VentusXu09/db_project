package com.example.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {

    private String customerName;

    private String payMethod;

    private String cardNum;
}
