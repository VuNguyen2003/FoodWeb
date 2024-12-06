package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @Column(name = "order_detail_id", length = 100)
    private String orderDetailId;

    @Column(name = "product_id", length = 100)
    private String productId;

    @Column(name = "order_id", length = 100)
    private String orderId;

    @Column(name = "order_quantity")
    private int orderQuantity;

    @Column(name = "order_total", precision = 10, scale = 2)
    private java.math.BigDecimal orderTotal;

    // Constructors
    public OrderDetails() {}

    public OrderDetails(String orderDetailId, String productId, String orderId, int orderQuantity, java.math.BigDecimal orderTotal) {
        this.orderDetailId = orderDetailId;
        this.productId = productId;
        this.orderId = orderId;
        this.orderQuantity = orderQuantity;
        this.orderTotal = orderTotal;
    }

    // Getters and Setters
    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public java.math.BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(java.math.BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }
}
