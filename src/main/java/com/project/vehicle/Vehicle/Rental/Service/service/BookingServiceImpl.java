package com.project.vehicle.Vehicle.Rental.Service.service;

import com.project.vehicle.Vehicle.Rental.Service.entity.Booking;
import com.project.vehicle.Vehicle.Rental.Service.entity.Payment;
import com.project.vehicle.Vehicle.Rental.Service.entity.User;
import com.project.vehicle.Vehicle.Rental.Service.entity.Vehicle;
import com.project.vehicle.Vehicle.Rental.Service.repositories.BookingRepository;
import com.project.vehicle.Vehicle.Rental.Service.repositories.PaymentRepository;
import com.project.vehicle.Vehicle.Rental.Service.repositories.UserRepository;
import com.project.vehicle.Vehicle.Rental.Service.repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Booking createBooking(Booking booking, String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        List<Vehicle> vehicles = booking.getVehicles().stream()
                .map(v -> vehicleRepository.findById(v.getVehicleId())
                        .orElseThrow(() -> new RuntimeException("Vehicle not found: " + v.getVehicleId())))
                .toList();

        booking.setUser(user);
        booking.setVehicles(vehicles);
        booking.setStatus("DONE");

        Payment payment = new Payment();
        payment.setAmount(booking.getTotalCost());
        payment.setPaymentDate(new Date());
        payment.setPaymentStatus("SUCCESS");
        booking.setPayments(payment);

        Booking savedBooking = bookingRepository.save(booking);

        // Create new payment for each booking
        payment.setBooking(savedBooking);

        paymentRepository.save(payment);

        return savedBooking;

    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public List<Booking> getBookingByUser(String username) {
        return bookingRepository.findByUserUsername(username);
    }


    @Override
    @Transactional
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Update vehicles
        List<Vehicle> vehicles = updatedBooking.getVehicles().stream()
                .map(v -> vehicleRepository.findById(v.getVehicleId())
                        .orElseThrow(() -> new RuntimeException("Vehicle not found: " + v.getVehicleId())))
                .toList();

//        existingBooking.setVehicles(vehicles);

        // Update status and cost
        existingBooking.setStatus(updatedBooking.getStatus());

        return bookingRepository.save(existingBooking);
    }

    @Override
    @Transactional
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (booking.getPayments() != null) {
            paymentRepository.delete(booking.getPayments());
        }
        booking.getVehicles().clear();
        bookingRepository.delete(booking);
    }



}
