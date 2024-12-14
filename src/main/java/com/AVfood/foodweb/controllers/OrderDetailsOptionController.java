package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.OrderDetailsOptionRequest;
import com.AVfood.foodweb.dtos.response.OrderDetailsOptionResponse;
import com.AVfood.foodweb.services.OrderDetailsOptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details-options")
public class OrderDetailsOptionController {

    private final OrderDetailsOptionService service;

    public OrderDetailsOptionController(OrderDetailsOptionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetailsOptionResponse>> getAllOrderDetailsOptions() {
        return ResponseEntity.ok(service.getAllOrderDetailsOptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsOptionResponse> getOrderDetailsOptionById(@PathVariable String id) {
        return ResponseEntity.ok(service.getOrderDetailsOptionById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDetailsOptionResponse> createOrderDetailsOption(@RequestBody OrderDetailsOptionRequest request) {
        return ResponseEntity.ok(service.createOrderDetailsOption(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailsOptionResponse> updateOrderDetailsOption(@PathVariable String id, @RequestBody OrderDetailsOptionRequest request) {
        return ResponseEntity.ok(service.updateOrderDetailsOption(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetailsOption(@PathVariable String id) {
        service.deleteOrderDetailsOption(id);
        return ResponseEntity.noContent().build();
    }
}
