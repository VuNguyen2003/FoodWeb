package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.RoleRequest;
import com.AVfood.foodweb.exceptions.RoleNotFoundException;
import com.AVfood.foodweb.models.Role;
import com.AVfood.foodweb.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(RoleRequest request) {
        Role role = new Role(request.getRoleId());
        return roleRepository.save(role);
    }

    public Role getRoleById(String id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role not found with id " + id));
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role updateRole(String id, RoleRequest request) {
        Role role = getRoleById(id);
        role.setRoleId(request.getRoleId());
        return roleRepository.save(role);
    }

    public void deleteRole(String id) {
        Role role = getRoleById(id);
        roleRepository.delete(role);
    }
}
