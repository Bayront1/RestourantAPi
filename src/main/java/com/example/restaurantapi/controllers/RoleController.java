package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Role;
import com.example.restaurantapi.repositories.GenericRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/role")
@PreAuthorize("hasAnyAuthority('3')")
public class RoleController extends GenericController<Role>{

    public RoleController(GenericRepository<Role> repository) {
        super(repository);
    }
}
