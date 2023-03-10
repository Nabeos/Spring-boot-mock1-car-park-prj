package com.example.carpark.entity.dto.trip;

public class TripDTO {
  private Long tripId;
  private String destination;
  private String departureTime;
  private String driver;
  private String carType;
  private int bookedTicketNumber;

  public TripDTO() {
  }

  public Long getTripId() {
    return tripId;
  }

  public void setTripId(Long tripId) {
    this.tripId = tripId;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public int getBookedTicketNumber() {
    return bookedTicketNumber;
  }

  public void setBookedTicketNumber(int bookedTicketNumber) {
    this.bookedTicketNumber = bookedTicketNumber;
  }

  public TripDTO(Long tripId, String destination, String departureTime, String driver, String carType,
      int bookedTicketNumber) {
    this.tripId = tripId;
    this.destination = destination;
    this.departureTime = departureTime;
    this.driver = driver;
    this.carType = carType;
    this.bookedTicketNumber = bookedTicketNumber;
  }

}
