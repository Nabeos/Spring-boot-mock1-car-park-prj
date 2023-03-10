package com.example.carpark.entity.dto.ticket;

public class TicketDTO {
  private Long ticketId;
  private String tripDestination;
  private String carLicensePlate;
  private String customerName;
  private String bookingTime;

  public TicketDTO() {
  }

  public TicketDTO(Long ticketId, String tripDestination, String carLicensePlate, String customerName,
      String bookingTime) {
    this.ticketId = ticketId;
    this.tripDestination = tripDestination;
    this.carLicensePlate = carLicensePlate;
    this.customerName = customerName;
    this.bookingTime = bookingTime;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getTripDestination() {
    return tripDestination;
  }

  public void setTripDestination(String tripDestination) {
    this.tripDestination = tripDestination;
  }

  public String getCarLicensePlate() {
    return carLicensePlate;
  }

  public void setCarLicensePlate(String carLicensePlate) {
    this.carLicensePlate = carLicensePlate;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getBookingTime() {
    return bookingTime;
  }

  public void setBookingTime(String bookingTime) {
    this.bookingTime = bookingTime;
  }

}
