package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.ProductOptionRequest;
import com.AVfood.foodweb.dtos.response.ProductOptionResponse;
import com.AVfood.foodweb.exceptions.ResourceNotFoundException;
import com.AVfood.foodweb.models.ProductOption;
import com.AVfood.foodweb.repositories.ProductOptionRepository;
import com.AVfood.foodweb.utils.ProductOptionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOptionService {

    private final ProductOptionRepository repository;

    public ProductOptionService(ProductOptionRepository repository) {
        this.repository = repository;
    }

    public List<ProductOptionResponse> getAllProductOptions() {
        return repository.findAll().stream()
                .map(ProductOptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductOptionResponse getProductOptionById(String id) {
        ProductOption productOption = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductOption not found with id: " + id));
        return ProductOptionMapper.toDTO(productOption);
    }

    public ProductOptionResponse createProductOption(ProductOptionRequest request) {
        ProductOption productOption = ProductOptionMapper.toEntity(request);
        ProductOption savedProductOption = repository.save(productOption);
        return ProductOptionMapper.toDTO(savedProductOption);
    }

    public ProductOptionResponse updateProductOption(String id, ProductOptionRequest request) {
        ProductOption existingProductOption = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductOption not found with id: " + id));
        existingProductOption.setProductId(request.getProductId());
        existingProductOption.setOptionCategoryId(request.getOptionCategoryId());
        ProductOption updatedProductOption = repository.save(existingProductOption);
        return ProductOptionMapper.toDTO(updatedProductOption);
    }

    public void deleteProductOption(String id) {
        ProductOption existingProductOption = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductOption not found with id: " + id));
        repository.delete(existingProductOption);
    }
}
