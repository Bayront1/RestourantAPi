package com.example.restaurantapi.services;

import com.example.restaurantapi.models.Dish;
import com.example.restaurantapi.repositories.DishRepository;
import org.springframework.stereotype.Service;

@Service
public class DishService extends GenericService<Dish> {
    public DishService(DishRepository repository) {
        super(repository);
    }
}
