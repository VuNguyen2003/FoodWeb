package com.AVfood.foodweb.dto;

import java.sql.Timestamp;

public class CartRequest {

    private String cartId;
    private String accountId;
    private String statusId;
    private Timestamp cartDate;

    // Constructors
    public CartRequest() {}

    public CartRequest(String cartId, String accountId, String statusId, Timestamp cartDate) {
        this.cartId = cartId;
        this.accountId = accountId;
        this.statusId = statusId;
        this.cartDate = cartDate;
    }

    // Getters and Setters
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
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

    public Timestamp getCartDate() {
        return cartDate;
    }

    public void setCartDate(Timestamp cartDate) {
        this.cartDate = cartDate;
    }
}
