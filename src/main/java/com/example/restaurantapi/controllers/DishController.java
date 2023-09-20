package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Dish;
import com.example.restaurantapi.models.Ingredient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.example.restaurantapi.repositories.GenericRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/dish")
@PreAuthorize("hasAnyAuthority('2')")
public class DishController extends GenericController<Dish> {
    public DishController(GenericRepository<Dish> repository) {
        super(repository);
    }
}

