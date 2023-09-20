package com.example.restaurantapi.services;


import com.example.restaurantapi.models.TypeZone;
import com.example.restaurantapi.repositories.RoleRepository;
import com.example.restaurantapi.repositories.TypeZoneRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeZoneService extends GenericService<TypeZone>{
    public TypeZoneService(TypeZoneRepository repository) {
        super(repository);
    }
}
