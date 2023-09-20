package com.example.restaurantapi.services;


import com.example.restaurantapi.models.Ingredient;
import com.example.restaurantapi.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService extends GenericService<Ingredient> {
    public IngredientService(IngredientRepository repository) {
        super(repository);
    }
}
