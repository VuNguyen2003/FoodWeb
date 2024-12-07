package com.AVfood.foodweb.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Token {
    @Id
    @Column(name = "Token_Id", nullable = false, unique = true)
    private String tokenId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account; // Liên kết với entity Account

    @Column(name = "Token_Value", nullable = false)
    private String tokenValue;

    @Column(name = "Created_Date", nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "Expiry_Date")
    private LocalDateTime expiryDate;

    @Column(name = "Is_Active", nullable = false)
    private boolean isActive = true;

    // Getters và setters
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
