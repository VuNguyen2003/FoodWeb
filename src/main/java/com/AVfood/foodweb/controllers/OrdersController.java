package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.Orders;
import com.AVfood.foodweb.dtos.request.OrdersRequest;
import com.AVfood.foodweb.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersService service;

    // Lấy danh sách tất cả các đơn hàng
    @GetMapping
    public List<Orders> getAllOrders() {
        return service.getAllOrders();
    }

    // Lấy thông tin chi tiết của một đơn hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable String id) {
        Orders order = service.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // Tạo mới đơn hàng
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody OrdersRequest dto) {
        Orders order = service.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    // Cập nhật đơn hàng theo ID
    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable String id, @RequestBody OrdersRequest dto) {
        Orders updatedOrder = service.updateOrder(id, dto);
        return ResponseEntity.ok(updatedOrder);
    }

    // Xóa đơn hàng theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
