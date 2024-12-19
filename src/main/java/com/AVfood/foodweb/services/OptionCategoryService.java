package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.response.OptionCategoryRespone;
import com.AVfood.foodweb.dtos.request.OptionCategoryRequest;
import com.AVfood.foodweb.exceptions.ResourceNotFoundException;
import com.AVfood.foodweb.models.OptionCategory;
import com.AVfood.foodweb.repositories.OptionCategoryRepository;
import com.AVfood.foodweb.utils.OptionCategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionCategoryService {

    private final OptionCategoryRepository repository;

    public OptionCategoryService(OptionCategoryRepository repository) {
        this.repository = repository;
    }

    public List<OptionCategoryRespone> getAllCategories() {
        return repository.findAll().stream()
                .map(OptionCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OptionCategoryRespone getCategoryById(String id) {
        OptionCategory category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OptionCategory not found with id: " + id));
        return OptionCategoryMapper.toDTO(category);
    }

    public OptionCategoryRespone createCategory(OptionCategoryRequest request) {
        OptionCategory category = OptionCategoryMapper.toEntity(request);
        OptionCategory savedCategory = repository.save(category);
        return OptionCategoryMapper.toDTO(savedCategory);
    }

    public OptionCategoryRespone updateCategory(String id, OptionCategoryRequest request) {
        OptionCategory existingCategory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OptionCategory not found with id: " + id));
        existingCategory.setCategoryName(request.getCategoryName());
        OptionCategory updatedCategory = repository.save(existingCategory);
        return OptionCategoryMapper.toDTO(updatedCategory);
    }

    public void deleteCategory(String id) {
        OptionCategory existingCategory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OptionCategory not found with id: " + id));
        repository.delete(existingCategory);
    }
}
