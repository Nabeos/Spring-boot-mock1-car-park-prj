package com.example.carpark.entity.dto.bookingoffice;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookingOfficeCreationDTO {
  @NotBlank(message = "Name is Mandatory")
  private String officeName;
  @NotNull(message = "Trip is mandatory")
  private Long trip;
  @NotBlank(message = "Phone is Mandatory")
  private String officePhone;
  @NotBlank(message = "Place is mandatory")
  private String officePlace;
  @NotNull(message = "Price is Mandatory")
  @Min(value=0, message="Must be greater than 0")
  private double officePrice;
  @NotBlank(message = "Start deadline is mandatory")
  private String startContractDeadline;
  @NotBlank(message = "End deadline is mandatory")
  private String endContractDeadline;

  public BookingOfficeCreationDTO(String officeName, Long trip, String officePhone, String officePlace,
      double officePrice, String startContractDeadline, String endContractDeadline) {
    this.officeName = officeName;
    this.trip = trip;
    this.officePhone = officePhone;
    this.officePlace = officePlace;
    this.officePrice = officePrice;
    this.startContractDeadline = startContractDeadline;
    this.endContractDeadline = endContractDeadline;
  }

  public BookingOfficeCreationDTO() {
  }

  public String getOfficeName() {
    return officeName;
  }

  public void setOfficeName(String officeName) {
    this.officeName = officeName;
  }

  public Long getTrip() {
    return trip;
  }

  public void setTrip(Long trip) {
    this.trip= trip;
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

}
