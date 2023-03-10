package com.example.carpark.entity.dto.bookingoffice;

public class BookingOfficeDTO {
  private Long officeId;
  private String officeName;
  public String tripDestination;
  private String officePhone;
  private String officePlace;
  private double officePrice;
  private String startContractDeadline;
  private String endContractDeadline;

  public BookingOfficeDTO() {
  }

  public BookingOfficeDTO(Long officeId, String officeName, String trip, String officePhone, String officePlace,
      double officePrice, String startContractDeadline, String endContractDeadline) {
    this.officeId = officeId;
    this.officeName = officeName;
    this.tripDestination = trip;
    this.officePhone = officePhone;
    this.officePlace = officePlace;
    this.officePrice = officePrice;
    this.startContractDeadline = startContractDeadline;
    this.endContractDeadline = endContractDeadline;
  }

  public Long getOfficeId() {
    return officeId;
  }

  public void setOfficeId(Long officeId) {
    this.officeId = officeId;
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

  public String getEndContractDeadline() {
    return endContractDeadline;
  }

  public void setEndContractDeadline(String endContractDeadline) {
    this.endContractDeadline = endContractDeadline;
  }

  public String getTripDestination() {
    return tripDestination;
  }

  public void setTripDestination(String tripDestination) {
    this.tripDestination = tripDestination;
  }

}
