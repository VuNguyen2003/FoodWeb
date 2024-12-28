package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.ProductRequest;
import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;

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

    // Các endpoint khác...

    // Endpoint để lấy sản phẩm với phân trang
    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return productService.getAllProducts(page, size);
    }

    // Các endpoint sắp xếp, tìm kiếm cũng nên nằm dưới cùng endpoint này
    @GetMapping("/price-range")
    public List<Product> getProductsByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/sorted/asc")
    public List<Product> getAllProductsSortedByPriceAsc() {
        return productService.getAllProductsSortedByPriceAsc();
    }

    @GetMapping("/sorted/desc")
    public List<Product> getAllProductsSortedByPriceDesc() {
        return productService.getAllProductsSortedByPriceDesc();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }
}
