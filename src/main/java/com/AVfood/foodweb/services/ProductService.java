package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.ProductRequest;
import com.AVfood.foodweb.exceptions.ProductNotFoundException;
import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
                request.getLikes()
        );
        return productRepository.save(product);
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
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
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    @Value("${image.upload-dir}")
    private String imageUploadDir; // Đường dẫn thư mục lưu trữ hình ảnh

    public Product createProductWithImage(ProductRequest productRequest, MultipartFile imageFile) throws IOException {
        String imageUrl = saveImage(imageFile); // Lưu hình ảnh và nhận đường dẫn

        // Tạo sản phẩm mới với đường dẫn hình ảnh
        Product product = new Product();
        product.setProductId(productRequest.getProductId());
        product.setCategoryId(productRequest.getCategoryId());
        product.setProductName(productRequest.getProductName());
        product.setProductDescription(productRequest.getProductDescription());
        product.setStock(productRequest.getStock());
        product.setProductImageUrl(imageUrl);  // Lưu đường dẫn hình ảnh vào product
        product.setView(0);
        product.setLikes(0);

        return productRepository.save(product); // Lưu sản phẩm vào cơ sở dữ liệu
    }

    private String saveImage(MultipartFile imageFile) throws IOException {
        // Tạo đường dẫn thư mục lưu trữ từ thuộc tính imageUploadDir
        Path uploadPath = Paths.get(imageUploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath); // Tạo thư mục nếu chưa tồn tại
        }

        // Tạo tên tệp duy nhất để tránh trùng lặp
        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // Lưu nội dung tệp vào đường dẫn filePath
        Files.write(filePath, imageFile.getBytes());

        // Trả về đường dẫn tương đối của hình ảnh, có thể dùng để lưu vào product_image_url
        return "/images/" + fileName;
    }
}
