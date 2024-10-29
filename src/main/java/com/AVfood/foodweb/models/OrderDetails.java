package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "OrderDetail")
public class OrderDetails implements Serializable {

    @Id
    @Column(name = "OrderDetailId", length = 100)
    private String orderDetailId;

    @Column(name = "ProductId", length = 100)
    private String productId;

    @Column(name = "OrderId", length = 100)
    private String orderId;

    @Column(name = "OrderQuantity")
    private int orderQuantity;

    @Column(name = "OrderTotal", precision = 10, scale = 2)
    private BigDecimal orderTotal;

    // Constructors
    public OrderDetails() {}

    public OrderDetails(String orderDetailId, String productId, String orderId, int orderQuantity, BigDecimal orderTotal) {
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
