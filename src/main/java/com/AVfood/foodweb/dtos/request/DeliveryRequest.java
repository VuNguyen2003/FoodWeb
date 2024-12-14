package com.AVfood.foodweb.dtos.request;

import java.sql.Timestamp;

public class DeliveryRequest {

    private String orderId;
    private String deliveryPersonName;
    private String deliveryPersonPhone;
    private String deliveryStatus;
    private Timestamp deliveryDate;

    // Constructors
    public DeliveryRequest() {}

    public DeliveryRequest(String orderId, String deliveryPersonName, String deliveryPersonPhone, String deliveryStatus, Timestamp deliveryDate) {
        this.orderId = orderId;
        this.deliveryPersonName = deliveryPersonName;
        this.deliveryPersonPhone = deliveryPersonPhone;
        this.deliveryStatus = deliveryStatus;
        this.deliveryDate = deliveryDate;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }

    public void setDeliveryPersonName(String deliveryPersonName) {
        this.deliveryPersonName = deliveryPersonName;
    }

    public String getDeliveryPersonPhone() {
        return deliveryPersonPhone;
    }

    public void setDeliveryPersonPhone(String deliveryPersonPhone) {
        this.deliveryPersonPhone = deliveryPersonPhone;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
