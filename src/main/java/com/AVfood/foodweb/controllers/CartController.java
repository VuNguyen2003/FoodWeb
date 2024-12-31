package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dto.CartRequest;
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

    /**
     * Tạo một Cart mới
     *
     * @param cartRequest Dữ liệu từ client để tạo Cart
     * @return Cart đã được tạo
     */
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartRequest cartRequest) {
        try {
            Cart createdCart = cartService.createCart(cartRequest);
            return ResponseEntity.ok(createdCart);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Lấy tất cả các Cart
     *
     * @return Danh sách tất cả các Cart
     */
    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }

    /**
     * Lấy một Cart theo ID
     *
     * @param cartId ID của Cart
     * @return Cart nếu tồn tại
     */
    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable String cartId) {
        try {
            Cart cart = cartService.getCartById(cartId);
            return ResponseEntity.ok(cart);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Cập nhật một Cart
     *
     * @param cartId      ID của Cart cần cập nhật
     * @param cartRequest Dữ liệu cập nhật từ client
     * @return Cart đã được cập nhật
     */
    @PutMapping("/{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable String cartId, @RequestBody CartRequest cartRequest) {
        try {
            Cart updatedCart = cartService.updateCart(cartId, cartRequest);
            return ResponseEntity.ok(updatedCart);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Xóa một Cart
     *
     * @param cartId ID của Cart cần xóa
     * @return ResponseEntity không có nội dung
     */
    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {
        try {
            cartService.deleteCart(cartId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
