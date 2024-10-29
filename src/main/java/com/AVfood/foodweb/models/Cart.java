package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Cart")
public class Cart implements Serializable {

    @Id
    @Column(name = "CartId", length = 100)
    private String cartId;

    @Column(name = "StatusId", length = 100)
    private String statusId;

    @Column(name = "CartDate")
    private Timestamp cartDate;

    // Constructors
    public Cart() {}

    public Cart(String cartId, String statusId, Timestamp cartDate) {
        this.cartId = cartId;
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
