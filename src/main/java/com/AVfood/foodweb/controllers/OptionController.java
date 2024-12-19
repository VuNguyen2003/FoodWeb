package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.OptionRequest;
import com.AVfood.foodweb.dtos.response.OptionResponse;
import com.AVfood.foodweb.services.OptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionController {

    private final OptionService service;

    public OptionController(OptionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OptionResponse>> getAllOptions() {
        return ResponseEntity.ok(service.getAllOptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionResponse> getOptionById(@PathVariable String id) {
        return ResponseEntity.ok(service.getOptionById(id));
    }

    @PostMapping
    public ResponseEntity<OptionResponse> createOption(@RequestBody OptionRequest request) {
        return ResponseEntity.ok(service.createOption(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionResponse> updateOption(@PathVariable String id, @RequestBody OptionRequest request) {
        return ResponseEntity.ok(service.updateOption(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable String id) {
        service.deleteOption(id);
        return ResponseEntity.noContent().build();
    }
}
