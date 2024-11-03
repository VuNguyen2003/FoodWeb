package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.ProductRequest;
import com.AVfood.foodweb.exceptions.ProductNotFoundException;
import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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
}
