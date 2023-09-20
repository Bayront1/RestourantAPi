package com.example.restaurantapi.controllers;


import com.example.restaurantapi.models.Ingredient;
import com.example.restaurantapi.models.Orders;
import com.example.restaurantapi.repositories.GenericRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/orders")
@PreAuthorize("hasAnyAuthority('1')")
public class OrderController extends GenericController<Orders> {
    public OrderController(GenericRepository<Orders> repository) {
        super(repository);
    }
}
