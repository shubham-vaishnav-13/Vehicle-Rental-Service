package com.project.vehicle.Vehicle.Rental.Service.service;

import com.project.vehicle.Vehicle.Rental.Service.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long vehicleId, Vehicle vehicle);
    void deleteVehicle(Long vehicleId);
    Vehicle getVehicleById(Long vehicleId);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleWithBookings(Long vehicleId);
}
