package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.ProductRequest;
import com.AVfood.foodweb.exceptions.ProductNotFoundException;
import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;  // Import đúng loại Page
import org.springframework.data.domain.PageRequest;  // Import đúng loại PageRequest
import org.springframework.data.domain.Pageable;  // Import đúng loại Pageable

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequest request) {
        Product product = new Product(
                request.getProductId(),
                request.getCategoryId(),
                request.getProductName(),
                request.getProductDescription(),
                request.getStock(),
                request.getProductImageUrl(),
                request.getView(),
                request.getLikes(),
                request.getPrice() // Nếu bạn đã cập nhật trường giá
        );
        return productRepository.save(product);
    }

    public Product getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));

        // Tăng số lượt xem khi sản phẩm được xem
        product.setView(product.getView() + 1);
        productRepository.save(product); // Lưu lại thay đổi

        return product; // Trả về sản phẩm đã cập nhật
    }


    // Phương thức lấy sản phẩm với phân trang
    // Phương thức lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Phương thức tìm kiếm sản phẩm theo tên gần đúng
    public List<Product> searchProducts(String name) {
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }

    public Product updateProduct(String id, ProductRequest request) {
        Product product = getProductById(id);
        product.setCategoryId(request.getCategoryId());
        product.setProductName(request.getProductName());
        product.setProductDescription(request.getProductDescription());
        product.setStock(request.getStock());
        product.setProductImageUrl(request.getProductImageUrl());
        product.setView(request.getView());
        product.setLikes(request.getLikes());
        product.setPrice(request.getPrice()); // Nếu bạn đã cập nhật trường giá
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    @Value("${image.upload-dir}")
    private String imageUploadDir;

    public Product createProductWithImage(ProductRequest productRequest, MultipartFile imageFile) throws IOException {
        String imageUrl = saveImage(imageFile);

        Product product = new Product();
        product.setProductId(productRequest.getProductId());
        product.setCategoryId(productRequest.getCategoryId());
        product.setProductName(productRequest.getProductName());
        product.setProductDescription(productRequest.getProductDescription());
        product.setStock(productRequest.getStock());
        product.setProductImageUrl(imageUrl);
        product.setView(0);
        product.setLikes(0);
        product.setPrice(productRequest.getPrice()); // Set price

        return productRepository.save(product);
    }

    private String saveImage(MultipartFile imageFile) throws IOException {
        Path uploadPath = Paths.get(imageUploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, imageFile.getBytes());

        return "/images/" + fileName;
    }

    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    // Phương thức lấy tất cả sản phẩm và sắp xếp theo giá tăng dần
    public List<Product> getAllProductsSortedByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    // Phương thức lấy tất cả sản phẩm và sắp xếp theo giá giảm dần
    public List<Product> getAllProductsSortedByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }
}
