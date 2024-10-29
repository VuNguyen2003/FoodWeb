package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.CartItem;
import com.AVfood.foodweb.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cartitem")
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/additems")
    public ResponseEntity<String> addItems(@RequestBody List<CartItem> items) {
        // Thêm logic để lưu các items vào cơ sở dữ liệu
        cartItemService.addCartItems(items);
        return ResponseEntity.ok("Received: " + items.toString());
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
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        if (!cartItemService.existsById(id)) {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy
        }

        cartItemService.removeCartItem(id); // Gọi service để xóa CartItem
        return ResponseEntity.noContent().build(); // Trả về 204 No Content
    }
}
