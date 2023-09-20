package com.example.restaurantapi.controllers;


import com.example.restaurantapi.models.Ingredient;
import com.example.restaurantapi.repositories.GenericRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/ingredient")
@PreAuthorize("hasAnyAuthority('2')")
public class IngredientController extends GenericController<Ingredient> {
    public IngredientController(GenericRepository<Ingredient> repository) {
        super(repository);
    }
}
