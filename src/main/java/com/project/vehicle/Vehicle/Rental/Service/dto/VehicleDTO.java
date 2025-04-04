package com.project.vehicle.Vehicle.Rental.Service.dto;
import com.project.vehicle.Vehicle.Rental.Service.entity.Vehicle;

import java.util.List;

public class VehicleDTO {
    private Long vehicleId;
    private String vehicleName;
    private String vehicleType;
    private String licensePlate;
    private boolean availability;
    private double rentPerDay;
    private List<BookingDTO> bookings;

    // Constructor
    public VehicleDTO(Vehicle vehicle) {
        this.vehicleId = vehicle.getVehicleId();
        this.vehicleName = vehicle.getVehicleName();
        this.vehicleType = vehicle.getVehicleType();
        this.licensePlate = vehicle.getLicensePlate();
        this.availability = vehicle.isAvailability();
        this.rentPerDay = vehicle.getRentPerDay();
        this.bookings = vehicle.getBookings().stream().map(BookingDTO::new).toList();
    }

    // Getters and Setters


    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }
}
