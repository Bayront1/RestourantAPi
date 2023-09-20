package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.modelUser;
import com.example.restaurantapi.repositories.GenericRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/users")
@PreAuthorize("hasAnyAuthority('3')")
public class UserController extends GenericController<modelUser>{

    public UserController(GenericRepository<modelUser> repository) {
        super(repository);
    }
}


