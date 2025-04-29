package com.example.assignment.controller;

import com.example.assignment.common.SuccessResponse;
import com.example.assignment.domain.Payment;
import com.example.assignment.service.PaymentService;
import com.example.assignment.dto.PaymentRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public SuccessResponse<Payment> createPayment(@RequestBody PaymentRequest request) {
        Payment payment = paymentService.createPayment(request.getAmount(), request.getPaymentMethod());
        return SuccessResponse.success(payment);
    }

    @GetMapping("/{paymentId}")
    public SuccessResponse<Payment> getPayment(@PathVariable String paymentId) {
        Payment payment = paymentService.getPayment(paymentId);
        return SuccessResponse.success(payment);
    }

    @GetMapping
    public SuccessResponse<List<Payment>> getAllPayment() {
        List<Payment> payments = paymentService.getAllPayments();
        return SuccessResponse.success(payments);
    }

    @PutMapping("/{paymentId}/cancel")
    public SuccessResponse<Payment> cancelPayment(@PathVariable String paymentId) {
        Payment payment = paymentService.cancelPayment(paymentId);
        return SuccessResponse.success(payment);
    }
}
