package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends GenericRepository<Dish> {
    List<Dish> findByName(String name);
}
