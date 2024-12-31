package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.ProductRequest;
import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép truy cập từ React frontend
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Tạo sản phẩm mới
    @PostMapping
    public ResponseEntity<Map<String, Object>> createProduct(
            @RequestPart("product") ProductRequest productRequest,
            @RequestPart("image") MultipartFile imageFile) throws IOException {
        Product product = productService.createProductWithImage(productRequest, imageFile);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product created successfully");
        response.put("product", product);
        return ResponseEntity.ok(response);
    }

    // Lấy thông tin sản phẩm theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // Lấy danh sách sản phẩm với phân trang
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Page<Product> productPage = productService.getAllProducts(page, size);
        Map<String, Object> response = new HashMap<>();
        response.put("products", productPage.getContent());
        response.put("currentPage", productPage.getNumber());
        response.put("totalItems", productPage.getTotalElements());
        response.put("totalPages", productPage.getTotalPages());
        return ResponseEntity.ok(response);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateProduct(
            @PathVariable String id,
            @Valid @RequestBody ProductRequest request) {
        Product updatedProduct = productService.updateProduct(id, request);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product updated successfully");
        response.put("product", updatedProduct);
        return ResponseEntity.ok(response);
    }

    // Xóa sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Product deleted successfully");
        return ResponseEntity.ok(response);
    }

    // Lấy sản phẩm theo khoảng giá
    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        return ResponseEntity.ok(productService.getProductsByPriceRange(minPrice, maxPrice));
    }

    // Lấy danh sách sản phẩm sắp xếp theo giá tăng dần
    @GetMapping("/sorted/asc")
    public ResponseEntity<List<Product>> getAllProductsSortedByPriceAsc() {
        return ResponseEntity.ok(productService.getAllProductsSortedByPriceAsc());
    }

    // Lấy danh sách sản phẩm sắp xếp theo giá giảm dần
    @GetMapping("/sorted/desc")
    public ResponseEntity<List<Product>> getAllProductsSortedByPriceDesc() {
        return ResponseEntity.ok(productService.getAllProductsSortedByPriceDesc());
    }

    // Tìm kiếm sản phẩm theo tên
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String name) {
        return ResponseEntity.ok(productService.searchProducts(name));
    }
}
