package com.AVfood.foodweb.dtos.response;

import java.time.LocalDateTime;

public class TokenResponse {

    private String tokenValue;
    private LocalDateTime expiryDate;

    // Constructor
    public TokenResponse(String tokenValue, LocalDateTime expiryDate) {
        this.tokenValue = tokenValue;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
