package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details_option")
public class OrderDetailsOption {

    @Id
    @Column(name = "order_details_option_id")
    private String orderDetailsOptionId;

    @Column(name = "order_detail_id", nullable = false)
    private String orderDetailId;

    @Column(name = "option_id", nullable = false)
    private String optionId;

    // Constructors
    public OrderDetailsOption() {}

    public OrderDetailsOption(String orderDetailsOptionId, String orderDetailId, String optionId) {
        this.orderDetailsOptionId = orderDetailsOptionId;
        this.orderDetailId = orderDetailId;
        this.optionId = optionId;
    }

    // Getters and Setters
    public String getOrderDetailsOptionId() {
        return orderDetailsOptionId;
    }

    public void setOrderDetailsOptionId(String orderDetailsOptionId) {
        this.orderDetailsOptionId = orderDetailsOptionId;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }
}