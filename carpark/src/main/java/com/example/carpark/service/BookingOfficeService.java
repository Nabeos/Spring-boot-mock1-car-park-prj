package com.example.carpark.service;

import java.util.List;

import com.example.carpark.entity.dto.bookingoffice.BookingOfficeCreationDTO;
import com.example.carpark.entity.dto.bookingoffice.BookingOfficeDTO;
import com.example.carpark.exception.custom.NotFoundException;

public interface BookingOfficeService {

  List<BookingOfficeDTO> displayBookingOfficeList(String searchName, String officeName, int offset, int limit)
      throws NotFoundException;

  void addBookingOffice(BookingOfficeCreationDTO dtoCreate) throws NotFoundException;

  void deleteBookingOffice(Long id);

  void updateBookingOffice(BookingOfficeCreationDTO dtoCreate, Long id) throws NotFoundException;

}
