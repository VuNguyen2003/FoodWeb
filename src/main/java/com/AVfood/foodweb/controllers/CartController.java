package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.Cart;
import com.AVfood.foodweb.dtos.request.CartRequest;
import com.AVfood.foodweb.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping
    public List<Cart> getAllCarts() {
        return service.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable String id) {
        Cart cart = service.getCartById(id);
        return ResponseEntity.ok(cart);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartRequest dto) {
        Cart cart = service.createCart(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable String id, @RequestBody CartRequest dto) {
        Cart updatedCart = service.updateCart(id, dto);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable String id) {
        service.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
