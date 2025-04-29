package com.example.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String paymentId;
    private Integer amount;
    private String paymentMethod;
    private String status;

    public static Payment create(Integer amount, String paymentMethod) {
        return new Payment(
                UUID.randomUUID().toString(),
                amount,
                paymentMethod,
                "CREATED"
        );
    }

    public void cancel() {
        if ("CANCELED".equals(this.status)) {
            throw new IllegalStateException("이미 취소된 결제입니다.");
        }
        this.status = "CANCELED";
    }
}
