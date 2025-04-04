package com.project.vehicle.Vehicle.Rental.Service.service;

import com.project.vehicle.Vehicle.Rental.Service.entity.Payment;
import com.project.vehicle.Vehicle.Rental.Service.repositories.BookingRepository;
import com.project.vehicle.Vehicle.Rental.Service.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(String.valueOf(id));
        if (payment.isPresent()){
            return payment.get();
        }
        throw new UsernameNotFoundException("No booking Found");
    }
}
