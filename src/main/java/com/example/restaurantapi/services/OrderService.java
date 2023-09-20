package com.example.restaurantapi.services;


import com.example.restaurantapi.models.Orders;
import com.example.restaurantapi.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericService<Orders> {
    public OrderService(OrderRepository repository) {
        super(repository);
    }
}
