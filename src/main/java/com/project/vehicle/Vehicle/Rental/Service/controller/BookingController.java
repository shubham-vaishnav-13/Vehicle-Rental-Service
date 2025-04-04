package com.project.vehicle.Vehicle.Rental.Service.controller;

import com.project.vehicle.Vehicle.Rental.Service.dto.BookingDTO;
import com.project.vehicle.Vehicle.Rental.Service.entity.Booking;
import com.project.vehicle.Vehicle.Rental.Service.entity.User;
import com.project.vehicle.Vehicle.Rental.Service.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> createBooking(@RequestBody Booking booking, Principal principal) {
        String username = principal.getName();


        bookingService.createBooking(booking,username);
        return ResponseEntity.ok("Booking Succeed");
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        List<BookingDTO> bookingDTOs = bookings.stream()
                .map(BookingDTO::new)  // Assuming BookingDTO has a constructor that takes a Booking
                .toList();
        return ResponseEntity.ok(bookingDTOs);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Booking> getPaymentById(@PathVariable Long id) {
//        return ResponseEntity.ok(bookingService.getPaymentById(id));
//    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<BookingDTO> getVehicleWithBookings(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(new BookingDTO(booking));
    }

    @GetMapping("bookings/user/{username}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable String username) {
        return ResponseEntity.ok(bookingService.getBookingByUser(username));
    }

    @PutMapping("bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updated = bookingService.updateBooking(id, booking);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("bookings/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully.");
    }
}
