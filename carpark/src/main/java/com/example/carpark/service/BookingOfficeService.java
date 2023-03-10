package com.example.carpark.service;

import java.util.List;

import com.example.carpark.entity.dto.bookingoffice.BookingOfficeCreationDTO;
import com.example.carpark.entity.dto.bookingoffice.BookingOfficeDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;

public interface BookingOfficeService {

  List<BookingOfficeDTO> displayBookingOfficeList(String searchName, String officeName, int offset, int limit)
      throws NotFoundException;

  void addBookingOffice(BookingOfficeCreationDTO dtoCreate) throws NotFoundException, BadRequestCustomException;

  void deleteBookingOffice(Long id) throws NotFoundException;

  void updateBookingOffice(BookingOfficeCreationDTO dtoCreate, Long id) throws NotFoundException, BadRequestCustomException;

}
