package com.project.vehicle.Vehicle.Rental.Service.controller;

import com.project.vehicle.Vehicle.Rental.Service.entity.Payment;
import com.project.vehicle.Vehicle.Rental.Service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }
}
