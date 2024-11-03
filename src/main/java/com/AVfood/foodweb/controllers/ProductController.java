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

    // Endpoint để lấy sản phẩm với phân trang
    @GetMapping("/products")
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,  // Số trang, mặc định là 0
            @RequestParam(defaultValue = "20") int size  // Kích thước mỗi trang, mặc định là 20
    ) {
        return productService.getAllProducts(page, size);
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

    // Endpoint để tìm kiếm sản phẩm
    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }
}
