package com.project.vehicle.Vehicle.Rental.Service.controller;

import com.project.vehicle.Vehicle.Rental.Service.dto.VehicleDTO;
import com.project.vehicle.Vehicle.Rental.Service.entity.Booking;
import com.project.vehicle.Vehicle.Rental.Service.entity.Vehicle;
import com.project.vehicle.Vehicle.Rental.Service.repositories.VehicleRepository;
import com.project.vehicle.Vehicle.Rental.Service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

//    @GetMapping
//    public List<Vehicle> getAllVehicles() {
//        return vehicleService.getAllVehicles();
//    }
    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles().stream()
                .map(VehicleDTO::new)
                .collect(Collectors.toList());
    }


    @GetMapping("vehicles/{id}")
    public ResponseEntity<VehicleDTO> getVehicleWithBookings(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleWithBookings(id);
        return ResponseEntity.ok(new VehicleDTO(vehicle));
    }



    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle){
        Vehicle savedVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    //Update Vehicle
    @PutMapping("vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id){
        Vehicle savedVehicle = vehicleService.updateVehicle(id,vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    @DeleteMapping("vehicles/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle deleted successfully.");
    }


}