package com.example.carpark.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carpark.entity.Trip;
import com.example.carpark.entity.dto.trip.TripCreationDTO;
import com.example.carpark.entity.dto.trip.TripDTO;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.repository.TripRepository;
import com.example.carpark.service.TripService;

@Service
public class TripServiceImpl implements TripService{
  @Autowired
  private TripRepository repository;
  @Autowired
  private ModelMapper model;

  @Override
  public List<TripDTO> getTripList(String searchName, String field, int offset, int limit) {
    List<Trip> trips = repository.findAll();
    return trips.stream().map(t -> model.map(t, TripDTO.class)).collect(Collectors.toList());
  }

  @Override
  public void addTrip(TripCreationDTO dto) {
    Trip trip = model.map(dto, Trip.class);
    repository.save(trip);
  }

  @Override
  public void deleteTrip(Long id) throws NotFoundException {
    Trip trip = repository.findById(id).orElseThrow(()->new NotFoundException("Not found trip"));
    trip.getTickets().forEach(t->trip.removeTicket(t));
    trip.getBookingOffices().forEach(b->trip.removeBookingOffice(b));
    repository.delete(trip);
  }

  @Override
  public void updateTrip(TripCreationDTO dtoCreate, Long id) throws NotFoundException {
    Trip trip = repository.findById(id).orElseThrow(()->new NotFoundException("Not found trip"));
    trip.setCarType(dtoCreate.getCarType());
    trip.setDepartureDate(dtoCreate.getDepartureDate());
    trip.setDepartureTime(dtoCreate.getDepartureTime());
    trip.setDestination(dtoCreate.getDestination());
    trip.setDriver(dtoCreate.getDriver());
    trip.setMaximumOnlineTicketNumber(dtoCreate.getMaximumOnlineTicketNumber());
    repository.save(trip);
  }
}
