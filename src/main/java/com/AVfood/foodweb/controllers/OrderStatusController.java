package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.OrderStatusRequest;
import com.AVfood.foodweb.dtos.response.OrderStatusResponse;
import com.AVfood.foodweb.exceptions.ResourceNotFoundException;
import com.AVfood.foodweb.services.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-status")
public class OrderStatusController {

    private final OrderStatusService orderStatusService;

    @Autowired
    public OrderStatusController(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @PostMapping
    public ResponseEntity<OrderStatusResponse> createOrderStatus(@RequestBody OrderStatusRequest requestDTO) {
        OrderStatusResponse responseDTO = orderStatusService.createOrderStatus(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderStatusResponse>> getAllOrderStatuses() {
        List<OrderStatusResponse> orderStatuses = orderStatusService.getAllOrderStatuses();
        return new ResponseEntity<>(orderStatuses, HttpStatus.OK);
    }

    @GetMapping("/{statusId}")
    public ResponseEntity<OrderStatusResponse> getOrderStatusById(@PathVariable String statusId) {
        // Kiểm tra nếu không tìm thấy OrderStatus, ném ngoại lệ
        OrderStatusResponse responseDTO = orderStatusService.getOrderStatusById(statusId);
        if (responseDTO == null) {
            throw new ResourceNotFoundException("OrderStatus with ID " + statusId + " not found.");
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{statusId}")
    public ResponseEntity<OrderStatusResponse> updateOrderStatus(
            @PathVariable String statusId,
            @RequestBody OrderStatusRequest requestDTO) {
        OrderStatusResponse responseDTO = orderStatusService.updateOrderStatus(statusId, requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{statusId}")
    public ResponseEntity<Void> deleteOrderStatus(@PathVariable String statusId) {
        orderStatusService.deleteOrderStatus(statusId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
