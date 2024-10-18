package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Order")
public class Order implements Serializable {

    @Id
    @Column(name = "OrderId", nullable = false, length = 100)
    private String orderId;

    @Column(name = "StatusId", nullable = false, length = 100)
    private String statusId;

    @Column(name = "OrderName", nullable = false, length = 100)
    private String orderName;

    // Constructors
    public Order() {}

    public Order(String orderId, String statusId, String orderName) {
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
