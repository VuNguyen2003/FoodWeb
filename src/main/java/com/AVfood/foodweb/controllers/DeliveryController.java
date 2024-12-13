package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.Delivery;
import com.AVfood.foodweb.dtos.request.DeliveryRequest;
import com.AVfood.foodweb.dtos.response.DeliveryResponse;
import com.AVfood.foodweb.utils.DeliveryMapper;
import com.AVfood.foodweb.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    // Tạo hoặc cập nhật Delivery
    @PostMapping
    public ResponseEntity<DeliveryResponse> createOrUpdateDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        Delivery delivery = DeliveryMapper.INSTANCE.deliveryRequestToDelivery(deliveryRequest);
        Delivery savedDelivery = deliveryService.saveDelivery(delivery);
        DeliveryResponse response = DeliveryMapper.INSTANCE.deliveryToDeliveryResponse(savedDelivery);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Lấy Delivery theo ID
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponse> getDeliveryById(@PathVariable String id) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        DeliveryResponse response = DeliveryMapper.INSTANCE.deliveryToDeliveryResponse(delivery);
        return ResponseEntity.ok(response);
    }

    // Lấy Delivery theo Order ID
    @GetMapping("/order/{orderId}")
    public ResponseEntity<DeliveryResponse> getDeliveryByOrderId(@PathVariable String orderId) {
        Delivery delivery = deliveryService.getDeliveryByOrderId(orderId);
        if (delivery == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        DeliveryResponse response = DeliveryMapper.INSTANCE.deliveryToDeliveryResponse(delivery);
        return ResponseEntity.ok(response);
    }
}
