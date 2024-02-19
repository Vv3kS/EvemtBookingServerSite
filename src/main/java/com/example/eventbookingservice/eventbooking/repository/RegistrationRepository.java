package com.example.eventbookingservice.eventbooking.repository;

import com.example.eventbookingservice.eventbooking.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    // You can add custom query methods here if needed
    public Registration findByUsername(String username);
}