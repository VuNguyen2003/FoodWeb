package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.StatusRequest;
import com.AVfood.foodweb.models.Status;
import com.AVfood.foodweb.services.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody StatusRequest request) {
        return ResponseEntity.ok(statusService.createStatus(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable String id) {
        return ResponseEntity.ok(statusService.getStatusById(id));
    }

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatuses() {
        return ResponseEntity.ok(statusService.getAllStatuses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable String id, @RequestBody StatusRequest request) {
        return ResponseEntity.ok(statusService.updateStatus(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable String id) {
        statusService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
}
