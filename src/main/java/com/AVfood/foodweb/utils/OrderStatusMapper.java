package com.AVfood.foodweb.utils;

import com.AVfood.foodweb.dtos.request.OrderStatusRequest;
import com.AVfood.foodweb.dtos.response.OrderStatusResponse;
import com.AVfood.foodweb.models.OrderStatus;

public class OrderStatusMapper {

    // Chuyển từ OrderStatus entity sang OrderStatusResponse
    public static OrderStatusResponse toResponseDTO(OrderStatus orderStatus) {
        return new OrderStatusResponse(orderStatus.getStatusId(), orderStatus.getStatusName());
    }

    // Chuyển từ OrderStatusRequest sang OrderStatus entity
    public static OrderStatus toEntity(OrderStatusRequest requestDTO) {
        return new OrderStatus(null, requestDTO.getStatusName()); // StatusId có thể là auto-generated
    }
}
