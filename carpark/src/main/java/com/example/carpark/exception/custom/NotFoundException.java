package com.example.carpark.exception.custom;

public class NotFoundException extends Exception {
  private String error;

  public NotFoundException(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

}
