package com.AVfood.foodweb.dtos.request;

public class OrderDetailsOptionRequest {
    private String orderDetailId;
    private String optionId;

    // Constructors
    public OrderDetailsOptionRequest() {}

    public OrderDetailsOptionRequest(String orderDetailId, String optionId) {
        this.orderDetailId = orderDetailId;
        this.optionId = optionId;
    }

    // Getters and Setters
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
