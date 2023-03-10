package com.example.carpark.entity;

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
@Table(name = "trip")
@DynamicUpdate
public class Trip {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long tripId;
  private int bookedTicketNumber;
  @Column(nullable = false)
  private String carType;
  @Column(nullable = false)
  private String departureDate;
  @Column(nullable = false)
  private String departureTime;
  @Column(nullable = false)
  private String destination;
  @Column(nullable = false)
  private String driver;
  @Column(nullable = false)
  private int maximumOnlineTicketNumber;

  @OneToMany(mappedBy = "trip")
  private List<Ticket> tickets;

  @OneToMany(mappedBy = "trip")
  private List<BookingOffice> bookingOffices;

  public Trip() {
  }

  public Trip(Long tripId, int bookedTicketNumber, String carType, String departureDate, String departureTime,
      String destination, String driver, int maximumOnlineTicketNumber, List<Ticket> tickets,
      List<BookingOffice> bookingOffices) {
    this.tripId = tripId;
    this.bookedTicketNumber = bookedTicketNumber;
    this.carType = carType;
    this.departureDate = departureDate;
    this.departureTime = departureTime;
    this.destination = destination;
    this.driver = driver;
    this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    this.tickets = tickets;
    this.bookingOffices = bookingOffices;
  }

  public Long getTripId() {
    return tripId;
  }

  public void setTripId(Long tripId) {
    this.tripId = tripId;
  }

  public int getBookedTicketNumber() {
    return bookedTicketNumber;
  }

  public void setBookedTicketNumber(int bookedTicketNumber) {
    this.bookedTicketNumber = bookedTicketNumber;
  }

  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public int getMaximumOnlineTicketNumber() {
    return maximumOnlineTicketNumber;
  }

  public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
    this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }

  public List<BookingOffice> getBookingOffices() {
    return bookingOffices;
  }

  public void setBookingOffices(List<BookingOffice> bookingOffices) {
    this.bookingOffices = bookingOffices;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public void removeTicket(Ticket ticket){
    ticket.setTrip(null);
  }

  public void removeBookingOffice(BookingOffice office){
    office.setTrip(null);
  }
}
