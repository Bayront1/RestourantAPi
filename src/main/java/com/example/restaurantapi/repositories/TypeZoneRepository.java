package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.TypeZone;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeZoneRepository extends GenericRepository<TypeZone>{
    TypeZone findByName(String name);
}
