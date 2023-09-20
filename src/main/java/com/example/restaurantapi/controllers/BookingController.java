package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Booking;
import com.example.restaurantapi.repositories.GenericRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/public/booking")
@PreAuthorize("hasAnyAuthority('1')")
public class BookingController extends GenericController<Booking> {
    public BookingController(GenericRepository<Booking> repository) {
        super(repository);
    }
}
