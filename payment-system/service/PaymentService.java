package com.example.paymentsystem.service;

import com.example.paymentsystem.model.PaymentEntity;
import com.example.paymentsystem.model.PaymentStatus;
import com.example.paymentsystem.repository.PaymentRepository;
import com.example.paymentsystem.gateway.PaymentStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.persistence.DiscriminatorValue;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired private PaymentRepository repository;
    @Autowired private ApplicationContext context;

    public String makePayment(PaymentEntity payment) {
        DiscriminatorValue dv = payment.getClass().getAnnotation(DiscriminatorValue.class);
        if (dv == null) throw new RuntimeException("Missing DiscriminatorValue annotation");
        String type = dv.value();
        PaymentStrategy strategy = (PaymentStrategy) context.getBean(type);
        boolean success = strategy.process(payment);
        payment.setStatus(success ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        repository.save(payment);
        return payment.getPaymentId();
    }

    public boolean refund(String paymentId) {
        Optional<PaymentEntity> opt = repository.findById(paymentId);
        if (opt.isPresent() && opt.get().getStatus() == PaymentStatus.SUCCESS) {
            opt.get().setStatus(PaymentStatus.REFUNDED);
            repository.save(opt.get());
            return true;
        }
        return false;
    }

    public PaymentStatus checkStatus(String paymentId) {
        return repository.findById(paymentId)
                .map(PaymentEntity::getStatus)
                .orElse(PaymentStatus.FAILED);
    }
}
