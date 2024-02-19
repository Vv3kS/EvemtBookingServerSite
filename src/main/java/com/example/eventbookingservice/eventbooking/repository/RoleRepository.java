package com.example.eventbookingservice.eventbooking.repository;

import com.example.eventbookingservice.eventbooking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // You can add custom query methods here if needed
}