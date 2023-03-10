package com.example.carpark.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
  public static boolean checkDate(String dob) {
    SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
    Date now = new Date();
    dfm.setLenient(false);
    try {
      Date dateOfBirth = dfm.parse(dob);
      if (dateOfBirth.compareTo(now) > 0)
        return false;
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return true;
  }
}
