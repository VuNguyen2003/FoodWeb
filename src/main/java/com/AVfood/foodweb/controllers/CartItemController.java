package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.CartItemRequest;
import com.AVfood.foodweb.exceptions.CartItemException; // Import exception
import com.AVfood.foodweb.models.CartItem;
import com.AVfood.foodweb.services.CartItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cartitem")
@CrossOrigin(origins = "http://localhost:3000")
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/additem")
    public ResponseEntity<String> addItem(@RequestBody @Valid CartItemRequest itemRequest) {
        if (itemRequest == null) {
            throw new CartItemException("Item không được null!");
        }
        cartItemService.addCartItem(itemRequest);
        return ResponseEntity.ok("Added: " + itemRequest.getCartItemId());
    }


    @GetMapping("/getallitems")
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> items = cartItemService.getAllCartItems();

        if (items.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về mã 204 nếu không có items nào
        }

        return ResponseEntity.ok(items); // Trả về mã 200 cùng với danh sách items
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable String id) {
        if (!cartItemService.existsById(id)) {
            throw new CartItemException("Không tìm thấy CartItem với ID: " + id); // Ném exception nếu không tìm thấy
        }

        cartItemService.removeCartItem(id); // Gọi service để xóa CartItem
        return ResponseEntity.noContent().build(); // Trả về 204 No Content
    }
}
