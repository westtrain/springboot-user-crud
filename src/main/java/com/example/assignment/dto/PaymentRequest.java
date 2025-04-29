package com.example.assignment.dto;

import lombok.Getter;

@Getter
public class PaymentRequest {
    private Integer amount;
    private String paymentMethod;
}
