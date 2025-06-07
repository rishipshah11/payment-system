package com.example.paymentsystem.gateway;

import com.example.paymentsystem.model.PaymentEntity;
import org.springframework.stereotype.Component;

@Component("CREDIT_CARD")
public class CreditCardPaymentStrategy implements PaymentStrategy {
    public boolean process(PaymentEntity payment) {
        System.out.println("Processing credit card payment...");
        return Math.random() > 0.1;
    }
}
