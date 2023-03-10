package com.example.carpark.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
@DynamicUpdate
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ticketId;
  private String bookingTime;
  @Column(nullable = false)
  private String customerName;

  @ManyToOne
  @JoinColumn(name = "licensePlate", nullable = false)
  private Car car;

  @ManyToOne
  @JoinColumn(name = "tripId")
  private Trip trip;

  public Ticket() {
  }

  public Ticket(Long ticketId, String bookingTime, String customerName, Car car) {
    this.ticketId = ticketId;
    this.bookingTime = bookingTime;
    this.customerName = customerName;
    this.car = car;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getBookingTime() {
    return bookingTime;
  }

  public void setBookingTime(String bookingTime) {
    this.bookingTime = bookingTime;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }

}
