package com.example.carpark.entity.dto.car;

public class CarDTO {
  private String licensePlate;
  private String carColor;
  private String carType;
  private String company;
  public String parkingLotName;

  public CarDTO() {
  }

  public CarDTO(String licensePlate, String carColor, String carType, String company, String parkingLot) {
    this.licensePlate = licensePlate;
    this.carColor = carColor;
    this.carType = carType;
    this.company = company;
    this.parkingLotName = parkingLot;
  }

  public String getLicensePlate() {
    return this.licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public String getCarColor() {
    return this.carColor;
  }

  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }

  public String getCarType() {
    return this.carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public String getCompany() {
    return this.company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getParkingLotName() {
    return this.parkingLotName;
  }

  public void setParkingLotName(String parkingLot) {
    this.parkingLotName = parkingLot;
  }

}
