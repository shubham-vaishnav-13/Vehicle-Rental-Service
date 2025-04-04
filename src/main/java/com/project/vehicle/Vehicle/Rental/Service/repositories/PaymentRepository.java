package com.project.vehicle.Vehicle.Rental.Service.repositories;

import com.project.vehicle.Vehicle.Rental.Service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,String> {
//    List<Payment> findByUserId(String userId);
}
