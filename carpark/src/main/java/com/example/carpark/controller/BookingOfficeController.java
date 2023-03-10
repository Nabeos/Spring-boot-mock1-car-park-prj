package com.example.carpark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.carpark.entity.dto.bookingoffice.BookingOfficeCreationDTO;
import com.example.carpark.entity.dto.bookingoffice.BookingOfficeDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.service.BookingOfficeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/practice")
public class BookingOfficeController {
  @Autowired
  private BookingOfficeService service;

  @GetMapping("/booking-offices")
  public List<BookingOfficeDTO> displayBookingOfficeList(
      @RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
      @RequestParam(name = "limit", defaultValue = "8", required = true) int limit,
      // searchField must be the same as column in database
      @RequestParam(name = "searchField", defaultValue = "officeId", required = true) String field,
      @RequestParam(name = "searchValue", defaultValue = "", required = false) String searchName)
      throws NotFoundException {
    return service.displayBookingOfficeList(searchName, field, offset, limit);
  }

  @PostMapping("/booking-offices")
  public String addBookingOffice(@RequestBody @Valid BookingOfficeCreationDTO dtoCreate) throws NotFoundException, BadRequestCustomException {
    service.addBookingOffice(dtoCreate);
    return "Add booking office successfully";
  }

  @DeleteMapping("/booking-offices")
  public String delete(@RequestParam Long id) throws NotFoundException {
    service.deleteBookingOffice(id);
    return "Delete successfully";
  }

  @PutMapping("/booking-offices/{id}")
  public String updateBookingOffice(@RequestBody @Valid BookingOfficeCreationDTO dtoCreate, @PathVariable Long id) throws NotFoundException, BadRequestCustomException {
    service.updateBookingOffice(dtoCreate, id);
    return "Update successfully";
  }
}
