package com.AVfood.foodweb.dtos.response;

public class OrderDetailsOptionResponse {
    private String orderDetailsOptionId;
    private String orderDetailId;
    private String optionId;

    // Constructors
    public OrderDetailsOptionResponse() {}

    public OrderDetailsOptionResponse(String orderDetailsOptionId, String orderDetailId, String optionId) {
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
