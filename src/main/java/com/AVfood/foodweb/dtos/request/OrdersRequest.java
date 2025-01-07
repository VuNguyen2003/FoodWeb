// src/main/java/com/AVfood/foodweb/dto/OrderRequest.java
package com.AVfood.foodweb.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class OrdersRequest {
    @NotNull(message = "Phương thức thanh toán không được để trống.")
    private String paymentMethod;

    @NotEmpty(message = "Đơn hàng phải có ít nhất một sản phẩm.")
    private List<OrderItem> items;

    // Getters and Setters

    public static class OrderItem {
        @NotNull(message = "ID sản phẩm không được để trống.")
        private String productId;

        @Min(value = 1, message = "Số lượng phải ít nhất là 1.")
        private int quantity;

        // Getters and Setters
    }
}
