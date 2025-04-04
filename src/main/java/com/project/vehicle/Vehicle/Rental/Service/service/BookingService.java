package com.project.vehicle.Vehicle.Rental.Service.service;

import com.project.vehicle.Vehicle.Rental.Service.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking,String username);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    List<Booking> getBookingByUser(String username);
    Booking updateBooking(Long id, Booking updatedBooking);
    void deleteBooking(Long id);
}
