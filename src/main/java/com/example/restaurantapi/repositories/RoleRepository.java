package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends GenericRepository<Role>{
    Role findByName(String name);
}
