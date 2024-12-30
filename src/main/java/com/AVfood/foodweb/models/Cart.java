package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @Column(name = "Cart_Id", length = 100)
    private String cartId;

    @ManyToOne
    @JoinColumn(name = "Account_Id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Status_Id")
    private Status status;

    @Column(name = "Cart_Date")
    private Timestamp cartDate;

    // Constructors
    public Cart() {}

    public Cart(String cartId, Account account, Status status, Timestamp cartDate) {
        this.cartId = cartId;
        this.account = account;
        this.status = status;
        this.cartDate = cartDate;
    }

    // Getters and Setters
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getCartDate() {
        return cartDate;
    }

    public void setCartDate(Timestamp cartDate) {
        this.cartDate = cartDate;
    }
}
