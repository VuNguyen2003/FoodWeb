package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.OrderDetails;
import com.AVfood.foodweb.dtos.request.OrderDetailsRequest;
import com.AVfood.foodweb.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<OrderDetails> getOrderDetailById(@PathVariable String id) {
        OrderDetails orderDetail = service.getOrderDetailById(id);
        return ResponseEntity.ok(orderDetail);
    }

    @PostMapping
    public ResponseEntity<OrderDetails> createOrderDetail(@RequestBody OrderDetailsRequest dto) {
        OrderDetails orderDetail = service.createOrderDetail(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetail(@PathVariable String id, @RequestBody OrderDetailsRequest dto) {
        OrderDetails updatedOrderDetail = service.updateOrderDetail(id, dto);
        return ResponseEntity.ok(updatedOrderDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable String id) {
        service.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}
