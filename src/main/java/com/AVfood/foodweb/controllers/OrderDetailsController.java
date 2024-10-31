package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.OrderDetails;
import com.AVfood.foodweb.dto.request.OrderDetailsRequest;
import com.AVfood.foodweb.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-details")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService service;

    @GetMapping
    public List<OrderDetails> getAllOrderDetails() {
        return service.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public OrderDetails getOrderDetailById(@PathVariable String id) {
        return service.getOrderDetailById(id);
    }

    @PostMapping
    public OrderDetails createOrderDetail(@RequestBody OrderDetailsRequest dto) {
        return service.createOrderDetail(dto);
    }

    @PutMapping("/{id}")
    public OrderDetails updateOrderDetail(@PathVariable String id, @RequestBody OrderDetailsRequest dto) {
        return service.updateOrderDetail(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable String id) {
        service.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}
