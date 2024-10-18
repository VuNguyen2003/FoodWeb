package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail implements Serializable {

    @Id
    @Column(name = "OrderDetailId", nullable = false, length = 100)
    private String orderDetailId;

    @Column(name = "ProductId", nullable = false, length = 100)
    private String productId;

    @Column(name = "OrderId", nullable = false, length = 100)
    private String orderId;

    @Column(name = "OrderQuantity", nullable = false)
    private int orderQuantity;

    @Column(name = "OrderTotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal orderTotal;

    // Constructors
    public OrderDetail() {}

    public OrderDetail(String orderDetailId, String productId, String orderId, int orderQuantity, BigDecimal orderTotal) {
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

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }
}
