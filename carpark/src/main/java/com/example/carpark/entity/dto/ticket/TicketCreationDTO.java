package com.example.carpark.entity.dto.ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TicketCreationDTO {
  @NotBlank(message = "Customer is mandatory")
  private String customerName;
  @NotBlank(message = "Booking time is mandatory")
  private String bookingTime;
  @NotNull(message = "Trip is mandatory")
  private Long tripId;
  @NotBlank(message = "License Plate is mandatory")
  private String carLicensePlate;

  public TicketCreationDTO() {
  }

  public TicketCreationDTO(String customer, String bookingTime, Long tripId, String carLicensePlate) {
    this.customerName = customer;
    this.bookingTime = bookingTime;
    this.tripId = tripId;
    this.carLicensePlate = carLicensePlate;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customer) {
    this.customerName = customer;
  }

  public String getBookingTime() {
    return bookingTime;
  }

  public void setBookingTime(String bookingTime) {
    this.bookingTime = bookingTime;
  }

  public Long getTripId() {
    return tripId;
  }

  public void setTripId(Long tripId) {
    this.tripId = tripId;
  }

  public String getCarLicensePlate() {
    return carLicensePlate;
  }

  public void setCarLicensePlate(String carLicensePlate) {
    this.carLicensePlate = carLicensePlate;
  }

}
