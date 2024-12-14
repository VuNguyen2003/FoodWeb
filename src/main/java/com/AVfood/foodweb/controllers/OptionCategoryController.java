package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.response.OptionCategoryRespone;
import com.AVfood.foodweb.dtos.request.OptionCategoryRequest;
import com.AVfood.foodweb.services.OptionCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/option-categories")
public class OptionCategoryController {

    private final OptionCategoryService service;

    public OptionCategoryController(OptionCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OptionCategoryRespone>> getAllCategories() {
        return ResponseEntity.ok(service.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionCategoryRespone> getCategoryById(@PathVariable String id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<OptionCategoryRespone> createCategory(@RequestBody OptionCategoryRequest request) {
        return ResponseEntity.ok(service.createCategory(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionCategoryRespone> updateCategory(@PathVariable String id, @RequestBody OptionCategoryRequest request) {
        return ResponseEntity.ok(service.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}