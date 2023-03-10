package com.example.carpark.entity.dto.parkinglot;

public class ParkingLotDTO {
  private Long parkId;
  private double parkArea;
  private String parkName;
  private String parkPlace;
  private double parkPrice;
  private String parkStatus;

  public ParkingLotDTO() {
  }

  public ParkingLotDTO(Long parkId, double parkArea, String parkName, String parkPlace, double parkPrice,
      String parkStatus) {
    this.parkId = parkId;
    this.parkArea = parkArea;
    this.parkName = parkName;
    this.parkPlace = parkPlace;
    this.parkPrice = parkPrice;
    this.parkStatus = parkStatus;
  }

  public Long getParkId() {
    return parkId;
  }

  public void setParkId(Long parkId) {
    this.parkId = parkId;
  }

  public double getParkArea() {
    return parkArea;
  }

  public void setParkArea(double parkArea) {
    this.parkArea = parkArea;
  }

  public String getParkName() {
    return parkName;
  }

  public void setParkName(String parkName) {
    this.parkName = parkName;
  }

  public String getParkPlace() {
    return parkPlace;
  }

  public void setParkPlace(String parkPlace) {
    this.parkPlace = parkPlace;
  }

  public double getParkPrice() {
    return parkPrice;
  }

  public void setParkPrice(double parkPrice) {
    this.parkPrice = parkPrice;
  }

  public String getParkStatus() {
    return parkStatus;
  }

  public void setParkStatus(String parkStatus) {
    this.parkStatus = parkStatus;
  }

}
