package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Registration;

import com.example.restaurantapi.models.modelUser;
import com.example.restaurantapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/public/login")
    public ResponseEntity<String> login(@RequestBody Registration request) {
        modelUser user = userRepository.findByUsername(request.getUsername());

        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}