package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.Cart;
import com.AVfood.foodweb.dtos.request.CartRequest;
import com.AVfood.foodweb.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Đánh dấu lớp này là một controller REST để xử lý các yêu cầu HTTP
@RestController
// Đặt đường dẫn URL cơ sở cho controller này
@RequestMapping("/api/v1/carts")
public class CartController {

    // Tự động tiêm CartService để xử lý logic cho các thao tác giỏ hàng
    @Autowired
    private CartService service;

    // Endpoint để lấy danh sách tất cả các giỏ hàng
    @GetMapping
    public List<Cart> getAllCarts() {
        // Gọi lớp service để lấy tất cả các bản ghi giỏ hàng
        return service.getAllCarts();
    }

    // Endpoint để lấy một giỏ hàng dựa trên ID duy nhất
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable String id) {
        // Gọi lớp service để tìm giỏ hàng theo ID
        Cart cart = service.getCartById(id);
        // Trả về giỏ hàng tìm thấy với trạng thái HTTP 200 OK
        return ResponseEntity.ok(cart);
    }

    // Endpoint để tạo một giỏ hàng mới
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartRequest dto) {
        // Gọi lớp service để tạo giỏ hàng mới bằng dữ liệu từ body của yêu cầu
        Cart cart = service.createCart(dto);
        // Trả về giỏ hàng vừa tạo với trạng thái HTTP 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }

    // Endpoint để cập nhật giỏ hàng hiện có dựa trên ID
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable String id, @RequestBody CartRequest dto) {
        // Gọi lớp service để cập nhật giỏ hàng có ID được cung cấp
        Cart updatedCart = service.updateCart(id, dto);
        // Trả về giỏ hàng đã cập nhật với trạng thái HTTP 200 OK
        return ResponseEntity.ok(updatedCart);
    }

    // Endpoint để xóa giỏ hàng dựa trên ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable String id) {
        // Gọi lớp service để xóa giỏ hàng có ID được cung cấp
        service.deleteCart(id);
        // Trả về trạng thái HTTP 204 No Content vì phản hồi không có nội dung
        return ResponseEntity.noContent().build();
    }
}
