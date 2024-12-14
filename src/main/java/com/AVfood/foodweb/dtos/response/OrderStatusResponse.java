package com.AVfood.foodweb.dtos.response;

public class OrderStatusResponse {

    private String statusId;
    private String statusName;

    // Constructors
    public OrderStatusResponse() {}

    public OrderStatusResponse(String statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    // Getters and Setters
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
