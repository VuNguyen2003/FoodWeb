// Orders.java
package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "Order_Id", length = 100)
    private String orderId;

    @Column(name = "Account_Id", length = 100) // Maps to the "Account_Id" column in the database
    private String accountId;

    @Column(name = "Status_Id", length = 100)
    private String statusId;

    @Column(name = "Order_Name", length = 100)
    private String orderName;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetails;

    // Constructors, Getters, and Setters
    public Orders() {}

    public Orders(String orderId, String accountId, String statusId, String orderName) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.orderName = orderName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
