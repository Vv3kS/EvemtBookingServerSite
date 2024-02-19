package com.example.eventbookingservice.eventbooking.service;

import com.example.eventbookingservice.eventbooking.entity.Registration;
import com.example.eventbookingservice.eventbooking.entity.Role;
import com.example.eventbookingservice.eventbooking.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RoleService roleService;

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(Long id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id " + id));
    }

    public Registration createRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Registration updateRegistration(Long id, Registration registrationDetails) {
        Registration registration = getRegistrationById(id);

        return registrationRepository.save(registration);
    }

    public void deleteRegistration(Long id) {
        Registration registration = getRegistrationById(id);
        registrationRepository.delete(registration);
    }

    public Registration getAuthentication(String userName, String password) {
        Registration registration = registrationRepository.findByUsername(userName);
        Role role = roleService.getRoleById(registration.getRole());
        System.out.println("role with give id is : "+ role.getRoleName());
        return registration;
    }
}

