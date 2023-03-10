package com.example.carpark.entity;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
@DynamicUpdate // only update changed fields
public class Car {
  @Id
  private String licensePlate;

  @Column(nullable = false)
  private String carColor;
  private String carType;
  private String company;

  @OneToMany(mappedBy = "car")
  private List<Ticket> tickets;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parkId")
  private ParkingLot parkingLot;

  public Car() {
  }

  public Car(String licensePlate, String carColor, String carType, String company, List<Ticket> tickets) {
    this.licensePlate = licensePlate;
    this.carColor = carColor;
    this.carType = carType;
    this.company = company;
    this.tickets = tickets;
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

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }

  public ParkingLot getParkingLot() {
    return parkingLot;
  }

  public void setParkingLot(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }

  public void addTicket(Ticket ticket) {
    this.tickets.add(ticket);
    ticket.setCar(this);
  }

  public void removeTicket(Ticket ticket) {
    tickets.remove(ticket);
  }
}
