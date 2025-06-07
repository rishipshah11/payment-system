package com.example.paymentsystem.gateway;

import com.example.paymentsystem.model.PaymentEntity;
import org.springframework.stereotype.Component;

@Component("NET_BANKING")
public class NetBankingPaymentStrategy implements PaymentStrategy {
    public boolean process(PaymentEntity payment) {
        System.out.println("Processing Net Banking payment...");
        return Math.random() > 0.15;
    }
}
