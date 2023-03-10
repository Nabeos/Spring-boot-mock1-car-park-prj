package com.example.carpark.entity.dto.parkinglot;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ParkingLotCreationDTO {
  @NotBlank(message = "Name is mandatory")
  private String parkName;
  @NotBlank(message = "Place is mandatory")
  private String parkPlace;
  @NotNull(message = "Area is mandatory")
  @Min(value = 0, message = "Area is greater than 0")
  private double parkArea;
  @NotNull(message = "Price is mandatory")
  @Min(value = 0, message = "Price is greater than 0")
  private double parkPrice;

  public ParkingLotCreationDTO() {
  }

  public ParkingLotCreationDTO(String parkName, String parkPlace, double parkArea, double parkPrice) {
    this.parkName = parkName;
    this.parkPlace = parkPlace;
    this.parkArea = parkArea;
    this.parkPrice = parkPrice;
  }

  public String getParkName() {
    return this.parkName;
  }

  public void setParkName(String parkName) {
    this.parkName = parkName;
  }

  public String getParkPlace() {
    return this.parkPlace;
  }

  public void setParkPlace(String parkPlace) {
    this.parkPlace = parkPlace;
  }

  public double getParkArea() {
    return this.parkArea;
  }

  public void setParkArea(double parkArea) {
    this.parkArea = parkArea;
  }

  public double getParkPrice() {
    return this.parkPrice;
  }

  public void setParkPrice(double parkPrice) {
    this.parkPrice = parkPrice;
  }

}
