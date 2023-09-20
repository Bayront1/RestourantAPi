package com.example.restaurantapi.services;

import com.example.restaurantapi.models.Role;
import com.example.restaurantapi.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Role>{
    public RoleService(RoleRepository repository) {
        super(repository);
    }
}
