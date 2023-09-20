package com.example.restaurantapi.models;

public interface GenericEntity<T> {


    void update(T source);
    long getId();

    T createNewInstance();

}