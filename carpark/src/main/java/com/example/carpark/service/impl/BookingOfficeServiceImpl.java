package com.example.carpark.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.carpark.entity.BookingOffice;
import com.example.carpark.entity.dto.bookingoffice.BookingOfficeCreationDTO;
import com.example.carpark.entity.dto.bookingoffice.BookingOfficeDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.repository.BookingOfficeRepository;
import com.example.carpark.repository.TripRepository;
import com.example.carpark.service.BookingOfficeService;
import com.example.carpark.utils.DateHelper;

@Service
public class BookingOfficeServiceImpl implements BookingOfficeService {

  @Autowired
  private BookingOfficeRepository repository;
  @Autowired
  private TripRepository tripRepository;

  @Autowired
  private ModelMapper model;

  @Override
  public List<BookingOfficeDTO> displayBookingOfficeList(String searchName, String officeName, int offset,
      int limit) throws NotFoundException {

    Pageable pageable = PageRequest.of(offset, limit, Sort.by(officeName));
    List<BookingOffice> bookingOffice = repository.getAllBookingOffices("%" + searchName + "%", pageable).getContent();

    if (bookingOffice.isEmpty() || bookingOffice == null)
      throw new NotFoundException("Empty");
    // convert entity to dto
    List<BookingOfficeDTO> bookingOfficeDTOs = bookingOffice.stream().map(b -> model.map(b, BookingOfficeDTO.class))
        .collect(Collectors.toList());
    return bookingOfficeDTOs;
  }

  @Override
  public void addBookingOffice(BookingOfficeCreationDTO dtoCreate) throws NotFoundException, BadRequestCustomException {
    if (!DateHelper.compareDeadline(dtoCreate.getStartContractDeadline(), dtoCreate.getEndContractDeadline()))
      throw new BadRequestCustomException("Invalid Contract date (start date must not exceed end date)");
    // check if trip exists
    tripRepository.findById(dtoCreate.getTrip()).orElseThrow(() -> new NotFoundException("Not found Trip"));
    // convert dto to entity
    BookingOffice bookingOffice = model.map(dtoCreate, BookingOffice.class);
    bookingOffice.setTrip(tripRepository.getReferenceById(dtoCreate.getTrip()));
    repository.save(bookingOffice);
  }

  @Override
  public void deleteBookingOffice(Long id) throws NotFoundException {
    BookingOffice office = repository.findById(id).orElseThrow(() -> new NotFoundException("Not found Booking Office"));
    repository.delete(office);
  }

  @Override
  public void updateBookingOffice(BookingOfficeCreationDTO dtoCreate, Long id)
      throws NotFoundException, BadRequestCustomException {
    if (!DateHelper.compareDeadline(dtoCreate.getStartContractDeadline(), dtoCreate.getEndContractDeadline()))
      throw new BadRequestCustomException("Invalid Contract date (start date must not exceed end date)");

    BookingOffice bookingOffice = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Office"));
    bookingOffice.setOfficeName(dtoCreate.getOfficeName());
    bookingOffice.setTrip(tripRepository.getReferenceById(dtoCreate.getTrip()));
    bookingOffice.setOfficePhone(dtoCreate.getOfficePhone());
    bookingOffice.setOfficePlace(dtoCreate.getOfficePlace());
    bookingOffice.setOfficePrice(dtoCreate.getOfficePrice());
    bookingOffice.setStartContractDeadline(dtoCreate.getStartContractDeadline());
    bookingOffice.setEndContractDeadline(dtoCreate.getEndContractDeadline());

    repository.save(bookingOffice);
  }

}
