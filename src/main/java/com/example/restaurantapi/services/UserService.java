package com.example.restaurantapi.services;

import com.example.restaurantapi.models.modelUser;
import com.example.restaurantapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<modelUser>{
    public UserService(UserRepository repository) {
        super(repository);
    }
}
