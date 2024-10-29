package com.AVfood.foodweb.service;

import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Sửa đổi kiểu tham số từ Long sang String
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(String id, Product product) {
        if (productRepository.existsById(id)) {
            product.setProductId(id); // Đảm bảo rằng ID được thiết lập đúng
            return productRepository.save(product);
        }
        return null; // hoặc có thể ném ra ngoại lệ
    }

    // Sửa đổi kiểu tham số từ Long sang String
    public boolean deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false; // hoặc có thể ném ra ngoại lệ
    }
}
