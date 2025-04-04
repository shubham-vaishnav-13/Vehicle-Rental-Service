package com.project.vehicle.Vehicle.Rental.Service.repositories;

import com.project.vehicle.Vehicle.Rental.Service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUsername(String username);
}