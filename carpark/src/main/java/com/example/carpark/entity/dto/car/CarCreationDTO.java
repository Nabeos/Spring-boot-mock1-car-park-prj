package com.example.carpark.entity.dto.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarCreationDTO {
  @NotBlank(message = "License Plate is mandatory")
  private String licensePlate;
  private String carColor;
  private String carType;
  @NotBlank(message = "Company is mandatory")
  private String company;
  @NotNull(message = "Parking Lot is mandatory")
  private Long parkId;
  public CarCreationDTO() {
  }
  public CarCreationDTO(String licensePlate, String carColor, String carType, String company, Long parkingLot) {
    this.licensePlate = licensePlate;
    this.carColor = carColor;
    this.carType = carType;
    this.company = company;
    this.parkId = parkingLot;
  }
  public String getLicensePlate() {
    return licensePlate;
  }
  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }
  public String getCarColor() {
    return carColor;
  }
  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }
  public String getCarType() {
    return carType;
  }
  public void setCarType(String carType) {
    this.carType = carType;
  }
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }
  public Long getParkId() {
    return parkId;
  }
  public void setParkId(Long parkingLot) {
    this.parkId = parkingLot;
  }

}
