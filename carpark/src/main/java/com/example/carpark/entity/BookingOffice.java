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
@Table(name = "bookingoffice")
@DynamicUpdate
public class BookingOffice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long officeId;
  private String endContractDeadline;
  @Column(nullable = false)
  private String officeName;
  @Column(nullable = false)
  private String officePhone;
  private String officePlace;
  @Column(nullable = false)
  private double officePrice;
  private String startContractDeadline;

  @ManyToOne
  @JoinColumn(name = "tripId")
  private Trip trip;

  public Trip getTrip() {
    return this.trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }

  public BookingOffice() {
  }

  public BookingOffice(Long officeId, String endContractDeadline, String officeName, String officePhone,
      String officePlace, double officePrice, String startContractDeadline) {
    this.officeId = officeId;
    this.endContractDeadline = endContractDeadline;
    this.officeName = officeName;
    this.officePhone = officePhone;
    this.officePlace = officePlace;
    this.officePrice = officePrice;
    this.startContractDeadline = startContractDeadline;
  }

  public double getOfficeId() {
    return officeId;
  }

  public void setOfficeId(Long officeId) {
    this.officeId = officeId;
  }

  public String getEndContractDeadline() {
    return endContractDeadline;
  }

  public void setEndContractDeadline(String endContractDeadline) {
    this.endContractDeadline = endContractDeadline;
  }

  public String getOfficeName() {
    return officeName;
  }

  public void setOfficeName(String officeName) {
    this.officeName = officeName;
  }

  public String getOfficePhone() {
    return officePhone;
  }

  public void setOfficePhone(String officePhone) {
    this.officePhone = officePhone;
  }

  public String getOfficePlace() {
    return officePlace;
  }

  public void setOfficePlace(String officePlace) {
    this.officePlace = officePlace;
  }

  public double getOfficePrice() {
    return officePrice;
  }

  public void setOfficePrice(double officePrice) {
    this.officePrice = officePrice;
  }

  public String getStartContractDeadline() {
    return startContractDeadline;
  }

  public void setStartContractDeadline(String startContractDeadline) {
    this.startContractDeadline = startContractDeadline;
  }

}
