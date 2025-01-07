// src/main/java/com/AVfood/foodweb/dto/OrderResponse.java
package com.AVfood.foodweb.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    private String orderId;
    private String accountId;
    private String statusId;
    private String orderName;
    private List<OrderDetailResponse> orderDetails;
    private BigDecimal total;
    private LocalDateTime date;
    private String paymentMethod;

    // Getters and Setters

    // Inner class to represent order details
    public static class OrderDetailResponse {
        private String productId;
        private String productName;
        private BigDecimal price;
        private int quantity;
        private BigDecimal orderTotal;

        // Getters and Setters
    }
}
