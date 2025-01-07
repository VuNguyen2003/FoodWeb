// OrderDetails.java
package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @Column(name = "Order_Detail_Id", length = 100)
    private String orderDetailId;

    @ManyToOne
    @JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Order_Id", referencedColumnName = "Order_Id")
    private Orders order;

    @Column(name = "Order_Quantity")
    private int orderQuantity;

    @Column(name = "Order_Total", precision = 10, scale = 2)
    private BigDecimal orderTotal;

    // Constructors, Getters, and Setters
    public OrderDetails() {}

    public OrderDetails(String orderDetailId, Product product, Orders order, int orderQuantity, BigDecimal orderTotal) {
        this.orderDetailId = orderDetailId;
        this.product = product;
        this.order = order;
        this.orderQuantity = orderQuantity;
        this.orderTotal = orderTotal;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
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
