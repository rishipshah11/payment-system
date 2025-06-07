package com.example.paymentsystem.gateway;

import com.example.paymentsystem.model.PaymentEntity;

public interface PaymentStrategy {
    boolean process(PaymentEntity payment);
}
