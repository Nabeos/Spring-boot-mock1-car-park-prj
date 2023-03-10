package com.example.carpark.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "parkinglot")
@DynamicUpdate
public class ParkingLot {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long parkId;
  private double parkArea;
  @Column(nullable = false)
  private String parkName;
  @Column(nullable = false)
  private String parkPlace;
  private double parkPrice;
  private String parkStatus;

  @OneToMany(mappedBy="parkingLot")
  private List<Car> cars = new ArrayList<>();
  public ParkingLot() {
  }

  public ParkingLot(Long parkId, double parkArea, String parkName, String parkPlace, double parkPrice,
      String parkStatus, List<Car> cars) {
    this.parkId = parkId;
    this.parkArea = parkArea;
    this.parkName = parkName;
    this.parkPlace = parkPlace;
    this.parkPrice = parkPrice;
    this.parkStatus = parkStatus;
    this.cars = cars;
  }

  public double getParkId() {
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

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public void addCar(Car car){
    this.cars.add(car);
    car.setParkingLot(this);
  }
  public void removeCar(Car car){
    car.setParkingLot(null);
  }
}
