package com.example.restaurantapi.repositories;


import com.example.restaurantapi.models.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends GenericRepository<Ingredient> {
    Ingredient findByName(String name);
}
