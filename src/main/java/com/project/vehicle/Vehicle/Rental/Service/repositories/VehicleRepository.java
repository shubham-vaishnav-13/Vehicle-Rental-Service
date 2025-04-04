package com.project.vehicle.Vehicle.Rental.Service.repositories;

import com.project.vehicle.Vehicle.Rental.Service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    @Query("SELECT v FROM Vehicle v LEFT JOIN FETCH v.bookings WHERE v.vehicleId = :id")
    Optional<Vehicle> findByIdWithBookings(@Param("id") Long id);


}
