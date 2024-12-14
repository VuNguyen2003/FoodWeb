package com.AVfood.foodweb.utils;

import com.AVfood.foodweb.dtos.request.OrderDetailsOptionRequest;
import com.AVfood.foodweb.dtos.response.OrderDetailsOptionResponse;
import com.AVfood.foodweb.models.OrderDetailsOption;

public class OrderDetailsOptionMapper {

    public static OrderDetailsOption toEntity(OrderDetailsOptionRequest request) {
        return new OrderDetailsOption(null, request.getOrderDetailId(), request.getOptionId());
    }

    public static OrderDetailsOptionResponse toDTO(OrderDetailsOption entity) {
        return new OrderDetailsOptionResponse(
                entity.getOrderDetailsOptionId(),
                entity.getOrderDetailId(),
                entity.getOptionId()
        );
    }
}
