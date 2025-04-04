package com.project.vehicle.Vehicle.Rental.Service.service;

import com.project.vehicle.Vehicle.Rental.Service.entity.Booking;
import com.project.vehicle.Vehicle.Rental.Service.entity.User;
import com.project.vehicle.Vehicle.Rental.Service.repositories.UserRepository;
import com.project.vehicle.Vehicle.Rental.Service.repositories.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> user =  userRepository.findById(String.valueOf(userId));
        if (user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("User is Not Found");
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<Booking> getMyBookings() {
        return List.of();
    }

    @Override
    @Transactional
    public User updateUserByNameAndLicenceNo(User user) {
        Optional<User> existingUserOptional = userRepository.findById(user.getUsername());
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            existingUser.setLicenceNo(user.getLicenceNo());
            existingUser.setName(user.getName());
            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            throw new EntityNotFoundException("User not found with username: " + user.getUsername());
        }
    }

}
