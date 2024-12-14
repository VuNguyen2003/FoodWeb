package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.ProductOptionRequest;
import com.AVfood.foodweb.dtos.response.ProductOptionResponse;
import com.AVfood.foodweb.services.ProductOptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-options")
public class ProductOptionController {

    private final ProductOptionService service;

    public ProductOptionController(ProductOptionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductOptionResponse>> getAllProductOptions() {
        return ResponseEntity.ok(service.getAllProductOptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOptionResponse> getProductOptionById(@PathVariable String id) {
        return ResponseEntity.ok(service.getProductOptionById(id));
    }

    @PostMapping
    public ResponseEntity<ProductOptionResponse> createProductOption(@RequestBody ProductOptionRequest request) {
        return ResponseEntity.ok(service.createProductOption(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOptionResponse> updateProductOption(@PathVariable String id, @RequestBody ProductOptionRequest request) {
        return ResponseEntity.ok(service.updateProductOption(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductOption(@PathVariable String id) {
        service.deleteProductOption(id);
        return ResponseEntity.noContent().build();
    }
}
