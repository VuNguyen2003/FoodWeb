package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.CartItem;
import com.AVfood.foodweb.reponsitorys.CartItemRepository;
import com.AVfood.foodweb.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/cartitem")
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService){
        this.cartItemService = cartItemService;
    }

    @PostMapping("/addItems")
    public String addItems(@RequestBody List<String> items) {
        return "Received: " + items.toString();
    }

    @GetMapping
    public List<CartItem> getAllUsers() {
        return CartItemRepository.findByProductId();
    }
}
