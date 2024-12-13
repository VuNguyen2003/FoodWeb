package com.AVfood.foodweb.utils;

import com.AVfood.foodweb.models.Delivery;
import com.AVfood.foodweb.dtos.request.DeliveryRequest;
import com.AVfood.foodweb.dtos.response.DeliveryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {

    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    // Ánh xạ từ DeliveryRequest sang Delivery entity
    Delivery deliveryRequestToDelivery(DeliveryRequest deliveryRequest);

    // Ánh xạ từ Delivery entity sang DeliveryResponse
    DeliveryResponse deliveryToDeliveryResponse(Delivery delivery);
}
