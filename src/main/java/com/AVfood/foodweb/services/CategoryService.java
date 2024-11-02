package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.CategoryRequest;
import com.AVfood.foodweb.exceptions.CategoryNotFoundException;
import com.AVfood.foodweb.models.Category;
import com.AVfood.foodweb.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryRequest request) {
        Category category = new Category(request.getCategoryId(), request.getStatusId(), request.getOrderName());
        return categoryRepository.save(category);
    }

    public Category getCategoryById(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id " + id));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(String id, CategoryRequest request) {
        Category category = getCategoryById(id);
        category.setStatusId(request.getStatusId());
        category.setOrderName(request.getOrderName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(String id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }
}
