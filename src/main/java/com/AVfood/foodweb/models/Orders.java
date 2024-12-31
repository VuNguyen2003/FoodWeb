package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "Order_Id", length = 100)
    private String orderId;

    @Column(name = "Status_Id", length = 100)
    private String statusId;

    @Column(name = "Order_Name", length = 100)
    private String orderName;

    // Constructors
    public Orders() {}

    public Orders(String orderId, String statusId, String orderName) {
        this.orderId = orderId;
        this.statusId = statusId;
        this.orderName = orderName;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
