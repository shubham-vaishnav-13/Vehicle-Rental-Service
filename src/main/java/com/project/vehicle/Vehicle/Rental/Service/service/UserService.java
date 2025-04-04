package com.project.vehicle.Vehicle.Rental.Service.service;

import com.project.vehicle.Vehicle.Rental.Service.entity.Booking;
import com.project.vehicle.Vehicle.Rental.Service.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getUserById(Long userId);
    List<User> getAllUser();
    List<Booking> getMyBookings();
    User updateUserByNameAndLicenceNo(User user);
}
