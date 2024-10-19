package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PaymentMethod")
public class PaymentMethod implements Serializable {

    @Id
    @Column(name = "PaymentMethodId", nullable = false, length = 100)
    private String paymentMethodId;

    @Column(name = "PaymentMethodName", length = 100)
    private String paymentMethodName;

    // Constructors
    public PaymentMethod() {}

    public PaymentMethod(String paymentMethodId, String paymentMethodName) {
        this.paymentMethodId = paymentMethodId;
        this.paymentMethodName = paymentMethodName;
    }

    // Getters and Setters
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }
}
