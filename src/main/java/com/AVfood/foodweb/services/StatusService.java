package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.StatusRequest;
import com.AVfood.foodweb.exceptions.StatusNotFoundException;
import com.AVfood.foodweb.models.Status;
import com.AVfood.foodweb.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status createStatus(StatusRequest request) {
        Status status = new Status(request.getStatusId(), request.getStatusName());
        return statusRepository.save(status);
    }

    public Status getStatusById(String id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new StatusNotFoundException("Status not found with id " + id));
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Status updateStatus(String id, StatusRequest request) {
        Status status = getStatusById(id);
        status.setStatusName(request.getStatusName());
        return statusRepository.save(status);
    }

    public void deleteStatus(String id) {
        Status status = getStatusById(id);
        statusRepository.delete(status);
    }
}
