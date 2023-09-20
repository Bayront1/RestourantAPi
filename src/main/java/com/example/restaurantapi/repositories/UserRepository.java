package com.example.restaurantapi.repositories;


import com.example.restaurantapi.models.modelUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<modelUser> {
    modelUser findByUsername(String username);
}
