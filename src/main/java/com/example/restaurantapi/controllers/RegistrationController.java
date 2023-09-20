package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.modelUser;
import com.example.restaurantapi.repositories.RoleRepository;
import com.example.restaurantapi.repositories.UserRepository;
import com.example.restaurantapi.models.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/registration")
public class RegistrationController {
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping()
    private ResponseEntity<String> reg(@RequestBody Registration registrationBody){
        modelUser userFromDB = UserRepository.findByUsername(registrationBody.getUsername());
        if (userFromDB != null){
            return ResponseEntity.badRequest().body("Пользователь с таким логином уже существует");
        }

        modelUser user = new modelUser();
        user.setActive(true);
        user.setRole(roleRepository.findByName("USER"));
        user.setUsername(registrationBody.getUsername());
        user.setPassword(passwordEncoder.encode(registrationBody.getPassword()));
        UserRepository.save(user);
        return ResponseEntity.ok("success");
    }

}
