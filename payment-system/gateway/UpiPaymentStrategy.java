package com.example.paymentsystem.gateway;

import com.example.paymentsystem.model.PaymentEntity;
import org.springframework.stereotype.Component;

@Component("UPI")
public class UpiPaymentStrategy implements PaymentStrategy {
    public boolean process(PaymentEntity payment) {
        System.out.println("Processing UPI payment...");
        return Math.random() > 0.2;
    }
}
