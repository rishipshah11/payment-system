package com.example.paymentsystem.controller;

import com.example.paymentsystem.model.CreditCardPaymentEntity;
import com.example.paymentsystem.model.UpiPaymentEntity;
import com.example.paymentsystem.model.NetBankingPaymentEntity;
import com.example.paymentsystem.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired private PaymentService service;

    @PostMapping("/credit-card")
    public ResponseEntity<String> payCard(@RequestBody CreditCardPaymentEntity p) {
        return ResponseEntity.ok("Payment ID: " + service.makePayment(p));
    }

    @PostMapping("/upi")
    public ResponseEntity<String> payUpi(@RequestBody UpiPaymentEntity p) {
        return ResponseEntity.ok("Payment ID: " + service.makePayment(p));
    }

    @PostMapping("/net-banking")
    public ResponseEntity<String> payBank(@RequestBody NetBankingPaymentEntity p) {
        return ResponseEntity.ok("Payment ID: " + service.makePayment(p));
    }

    @PostMapping("/refund/{id}")
    public ResponseEntity<String> refund(@PathVariable String id) {
        return ResponseEntity.ok(service.refund(id) ? "Refunded" : "Refund Failed");
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<String> status(@PathVariable String id) {
        return ResponseEntity.ok("Status: " + service.checkStatus(id));
    }
}
