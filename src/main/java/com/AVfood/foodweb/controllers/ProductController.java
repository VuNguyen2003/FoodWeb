package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.ProductRequest;
import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestPart("product") ProductRequest productRequest,
            @RequestPart("image") MultipartFile imageFile) throws IOException {
        Product product = productService.createProductWithImage(productRequest, imageFile);
        return ResponseEntity.ok(product);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/price-range")
    public List<Product> getProductsByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    //GET /products/sorted/asc
    // Endpoint lấy tất cả sản phẩm sắp xếp theo giá tăng dần
    @GetMapping("/products/sorted/asc")
    public List<Product> getAllProductsSortedByPriceAsc() {
        return productService.getAllProductsSortedByPriceAsc();
    }

    //GET /products/sorted/desc
    // Endpoint lấy tất cả sản phẩm sắp xếp theo giá giảm dần
    @GetMapping("/products/sorted/desc")
    public List<Product> getAllProductsSortedByPriceDesc() {
        return productService.getAllProductsSortedByPriceDesc();
    }
}
