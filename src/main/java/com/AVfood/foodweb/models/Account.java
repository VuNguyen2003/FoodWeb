package com.AVfood.foodweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @Column(name = "Account_Id", length = 100)
    private String accountId;

    @ManyToOne
    @JoinColumn(name = "Role_Id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "Payment_Method_Id")
    private PaymentMethod paymentMethod;

    @Column(name = "Full_Name", length = 255)
    private String fullName;

    @Column(name = "Email", length = 255)
    private String email;

    @Column(name = "Address", length = 100)
    private String address;

    @Column(name = "Username", length = 100)
    private String username;

    @Column(name = "Password", length = 100)
    private String password;

    // Constructors, Getters and Setters
    public Account() {}

    // Constructor with all fields
    public Account(String accountId, Role role, PaymentMethod paymentMethod, String fullName, String email, String address, String username, String password) {
        this.accountId = accountId;
        this.role = role;
        this.paymentMethod = paymentMethod;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Role getRoleId() {
        return role;
    }

    public void setRoleId(Role role) {
        this.role = role;
    }

    public PaymentMethod getPaymentMethodId() {
        return paymentMethod;
    }

    public void setPaymentMethodId(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
