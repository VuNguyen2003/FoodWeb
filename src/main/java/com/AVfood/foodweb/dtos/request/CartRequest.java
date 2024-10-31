package com.AVfood.foodweb.dtos.request;

import java.sql.Timestamp;

public class CartRequest {
    private String cartId;
    private String statusId;
    private Timestamp cartDate;

    // Getters and Setters
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public Timestamp getCartDate() {
        return cartDate;
    }

    public void setCartDate(Timestamp cartDate) {
        this.cartDate = cartDate;
    }
}
