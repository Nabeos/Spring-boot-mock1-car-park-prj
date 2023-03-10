package com.example.carpark.exception.custom;

public class BadRequestCustomException extends Exception {
  private String mess;

  public BadRequestCustomException(String message) {
    super(message);
  }

  public String getMess() {
    return mess;
  }

  public void setMess(String mess) {
    this.mess = mess;
  }

}
