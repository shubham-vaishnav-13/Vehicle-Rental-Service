package com.project.vehicle.Vehicle.Rental.Service.repositories;

import com.project.vehicle.Vehicle.Rental.Service.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository  extends JpaRepository<Booking,Long> {
    List<Booking> findByUserUsername(String username);

}
