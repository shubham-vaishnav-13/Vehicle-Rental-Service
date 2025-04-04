package com.project.vehicle.Vehicle.Rental.Service.controller;

import com.project.vehicle.Vehicle.Rental.Service.entity.User;
import com.project.vehicle.Vehicle.Rental.Service.entity.Vehicle;
import com.project.vehicle.Vehicle.Rental.Service.service.UserService;
import com.project.vehicle.Vehicle.Rental.Service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllVehicles() {
        return userService.getAllUser();
    }

    @PostMapping("/users")
    public ResponseEntity<User> adduser(@RequestBody User user){
        User saveduser = userService.addUser(user);
        return ResponseEntity.ok(saveduser);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User saveduser = userService.updateUserByNameAndLicenceNo(user);
        return ResponseEntity.ok(saveduser);
    }

}
