package com.project.vehicle.Vehicle.Rental.Service.dto;

import com.project.vehicle.Vehicle.Rental.Service.entity.User;

public class UserDTO {
    private String name;
    private String email;

    // Constructor
    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

