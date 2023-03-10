package com.example.carpark.entity.dto.trip;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TripCreationDTO {
  @NotBlank(message = "Destination is mandatory")
  private String destination;
  @NotBlank(message = "Departure time is mandatory")
  private String departureTime;
  @NotBlank(message = "Driver is mandatory")
  private String driver;
  @NotBlank(message = "Car type is mandatory")
  private String carType;
  @NotNull(message = "Maximum online ticket is mandatory")
  @Min(value = 1, message = "Maximum online ticket is greater than 1")
  private int maximumOnlineTicketNumber;
  @NotBlank(message = "Departure date is mandatory")
  private String departureDate;

  public TripCreationDTO() {
  }

  public TripCreationDTO(String destination, String departureTime, String driver, String carType,
      int maximumOnlineTicketNumber, String departureDate) {
    this.destination = destination;
    this.departureTime = departureTime;
    this.driver = driver;
    this.carType = carType;
    this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    this.departureDate = departureDate;
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

  public int getMaximumOnlineTicketNumber() {
    return maximumOnlineTicketNumber;
  }

  public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
    this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
  }

  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

}
