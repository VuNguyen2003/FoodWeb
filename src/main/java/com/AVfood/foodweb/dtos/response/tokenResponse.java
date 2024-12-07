package com.AVfood.foodweb.dtos.response;

import java.time.LocalDateTime;

public class tokenResponse {
    private String token;
    private LocalDateTime expiryDate;

    public tokenResponse(String token, LocalDateTime expiryDate) {
        this.token = token;
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
