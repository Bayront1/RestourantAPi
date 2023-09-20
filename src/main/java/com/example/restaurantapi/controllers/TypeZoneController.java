package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Role;
import com.example.restaurantapi.models.TypeZone;
import com.example.restaurantapi.repositories.GenericRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/typezone")
public class TypeZoneController extends GenericController<TypeZone>{

    public TypeZoneController(GenericRepository<TypeZone> repository) {
        super(repository);
    }
}
