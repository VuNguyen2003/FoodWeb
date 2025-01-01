package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.CartRequest;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.models.Cart;
import com.AVfood.foodweb.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartRequest request) {
        Cart createdCart = cartService.createCart(request);
        return ResponseEntity.ok(createdCart);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable String cartId) {
        Cart cart = cartService.getCartById(cartId);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/user/{accountId}")
    public ResponseEntity<List<Cart>> getCartsByAccountId(@PathVariable Account accountId) {
        List<Cart> carts = cartService.getCartsByAccountId(accountId);
        if (carts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carts);
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable String cartId, @RequestBody CartRequest request) {
        Cart updatedCart = cartService.updateCart(cartId, request);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }
}
