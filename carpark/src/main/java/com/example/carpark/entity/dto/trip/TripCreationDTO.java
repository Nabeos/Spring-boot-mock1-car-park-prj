package com.example.carpark.entity.dto.trip;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class TripCreationDTO {
  @NotBlank(message = "Destination is mandatory")
  private String destination;
  @NotBlank(message = "Departure time is mandatory")
  @Pattern(regexp="^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message="Must be HH:MM 24-hour format with 0 leading")
  private String departureTime;
  @NotBlank(message = "Driver is mandatory")
  private String driver;
  @NotBlank(message = "Car type is mandatory")
  private String carType;
  @NotNull(message = "Maximum online ticket is mandatory")
  @Min(value = 1, message = "Maximum online ticket is greater than 1")
  private int maximumOnlineTicketNumber;
  @NotBlank(message = "Departure date is mandatory")
  @Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/([19, 20]{2})?([0-9]{2})", message = "Must be dd/MM/yyyy format")
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
