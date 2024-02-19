package com.example.eventbookingservice.eventbooking.service;

import com.example.eventbookingservice.eventbooking.entity.Role;
import com.example.eventbookingservice.eventbooking.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Integer roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + roleId));
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Integer roleId, Role roleDetails) {
        Role role = getRoleById(roleId);
        role.setRoleName(roleDetails.getRoleName());
        return roleRepository.save(role);
    }

    public void deleteRole(Integer roleId) {
        Role role = getRoleById(roleId);
        roleRepository.delete(role);
    }
}