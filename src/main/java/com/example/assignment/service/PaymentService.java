package com.example.assignment.service;

import com.example.assignment.domain.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final List<Payment> payments = new ArrayList<>();

    public Payment createPayment(Integer amount, String paymentMethod) {
        Payment payment = Payment.create(amount, paymentMethod);
        payments.add(payment);
        return payment;
    }

    public Payment getPayment(String paymentId) {
        return findPaymentById(paymentId);
    }

    public List<Payment> getAllPayments() {
        return payments;
    }

    public Payment cancelPayment(String paymentId) {
        Payment payment = findPaymentById(paymentId);
        payment.cancel();
        return payment;
    }

    private Payment findPaymentById(String paymentId) {
        return payments.stream()
                .filter(payment -> payment.getPaymentId().equals(paymentId))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("해당 결제 내역을 찾을 수 없습니다."));
    }
}
