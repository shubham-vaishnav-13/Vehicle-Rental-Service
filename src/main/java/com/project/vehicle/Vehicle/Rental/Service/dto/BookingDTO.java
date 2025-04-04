package com.project.vehicle.Vehicle.Rental.Service.dto;

import com.project.vehicle.Vehicle.Rental.Service.entity.Booking;

public class BookingDTO {

    private Long bookingId;
    private String startDate;
    private String endDate;
    private String status;
    private UserDTO user;


    // Constructor
    public BookingDTO(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.startDate = booking.getStartDate().toString();
        this.endDate = booking.getEndDate().toString();
        this.status = booking.getStatus();
        this.user = new UserDTO(booking.getUser()); // Use UserDTO for filtering
    }

    // Getters and Setters


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}

