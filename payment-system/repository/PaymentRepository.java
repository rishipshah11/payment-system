package com.example.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.paymentsystem.model.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {}
