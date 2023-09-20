package com.example.restaurantapi.services;

import com.example.restaurantapi.models.Booking;
import com.example.restaurantapi.repositories.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService extends GenericService<Booking> {
    public BookingService(BookingRepository repository) {
        super(repository);
    }


}
