package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "cart_id", length = 100)
    private String cartId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "status_id", length = 100)
    private String statusId;

    @Column(name = "cart_date")
    private java.sql.Timestamp cartDate;

    // Constructors
    public Cart() {}

    public Cart(String cartId, String accountId, String statusId, java.sql.Timestamp cartDate) {
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

    public String getAccountId() { return accountId; }

    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public java.sql.Timestamp getCartDate() {
        return cartDate;
    }

    public void setCartDate(java.sql.Timestamp cartDate) {
        this.cartDate = cartDate;
    }
}
