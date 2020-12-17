package com.example.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private String invoiceId;

    private String paymMethod;

    private String cardNum;
}
