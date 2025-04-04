package com.project.vehicle.Vehicle.Rental.Service.service;

import com.project.vehicle.Vehicle.Rental.Service.entity.Vehicle;
import com.project.vehicle.Vehicle.Rental.Service.repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    @Transactional
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle) {
        Optional<Vehicle> vehicle1 = vehicleRepository.findById(vehicleId);
        if(vehicle1.isPresent()){
            Vehicle vehicle2 = vehicle1.get();
            vehicle2.setVehicleName(vehicle.getVehicleName());
            vehicle2.setVehicleType(vehicle.getVehicleType());
            vehicle2.setLicensePlate(vehicle.getLicensePlate());
            vehicle2.setRentPerDay(vehicle.getRentPerDay());
            return vehicleRepository.save(vehicle2);
        }
        throw new RuntimeException("Vehicle not found");
    }

    @Override
    @Transactional
    public void deleteVehicle(Long vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicleRepository.delete(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleWithBookings(Long vehicleId) {
        return vehicleRepository.findByIdWithBookings(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }



}
