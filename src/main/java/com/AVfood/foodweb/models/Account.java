package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Account")
public class Account implements Serializable {

    @Id
    @Column(name = "AccountId", length = 100)
    private String accountId;

    @Column(name = "RoleId", length = 100)
    private String roleId;

    @Column(name = "PaymentMethodId", length = 100)
    private String paymentMethodId;

    @Column(name = "CartId", length = 100)
    private String cartId;

    @Column(name = "FullName", length = 225)
    private String fullName;

    @Column(name = "Email", length = 225)
    private Timestamp email;

    @Column(name = "Address", length = 100)
    private String address;

    @Column(name = "Username", length = 100)
    private String username;

    @Column(name = "Password", length = 100)
    private String password;

    // Constructors
    public Account() {}

    public Account(String accountId, String roleId, String paymentMethodId, String cartId, String fullName, Timestamp email, String address, String username, String password) {
        this.accountId = accountId;
        this.roleId = roleId;
        this.paymentMethodId = paymentMethodId;
        this.cartId = cartId;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getEmail() {
        return email;
    }

    public void setEmail(Timestamp email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
