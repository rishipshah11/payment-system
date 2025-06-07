package com.example.paymentsystem.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("UPI")
public class UpiPaymentEntity extends PaymentEntity {
    private String vpa;
    public String getVpa() { return vpa; }
    public void setVpa(String vpa) { this.vpa = vpa; }
}
