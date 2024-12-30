package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Payment_Method")
public class PaymentMethod {

    @Id
    @Column(name = "Payment_Method_Id", length = 100)
    private String paymentMethodId;

    @Column(name = "Payment_Method_Name", length = 100)
    private String paymentMethodName;

    // Constructors, Getters and Setters
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
