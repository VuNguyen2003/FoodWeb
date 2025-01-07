// OrderController.java
package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.Orders;
import com.AVfood.foodweb.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersService orderService;

    /**
     * Create a new order
     * POST /api/orders
     * Request Body:
     * {
     *   "paymentMethod": "Credit Card",
     *   "items": [
     *     { "productId": "prod1", "quantity": 2 },
     *     { "productId": "prod2", "quantity": 1 }
     *   ]
     * }
     */
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Map<String, Object> payload, Principal principal) {
        String paymentMethod = (String) payload.get("paymentMethod");
        List<Map<String, Object>> items = (List<Map<String, Object>>) payload.get("items");
        String accountId = principal.getName(); // Simplification: using username as accountId

        Orders order = orderService.createOrder(accountId, paymentMethod, items);
        return ResponseEntity.ok(order);
    }

    /**
     * Get order history
     * GET /api/orders/history
     */
    @GetMapping("/history")
    public ResponseEntity<List<Orders>> getOrderHistory(Principal principal) {
        String accountId = principal.getName();
        List<Orders> orders = orderService.getOrderHistory(accountId);
        return ResponseEntity.ok(orders);
    }
}
