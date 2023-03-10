package com.example.carpark.service;

import java.util.List;

import com.example.carpark.entity.dto.trip.TripCreationDTO;
import com.example.carpark.entity.dto.trip.TripDTO;
import com.example.carpark.exception.custom.NotFoundException;

public interface TripService {

  List<TripDTO> getTripList(String searchName, String field, int offset, int limit);

  void addTrip(TripCreationDTO dto);

  void deleteTrip(Long id) throws NotFoundException;

  void updateTrip(TripCreationDTO dtoCreate, Long id) throws NotFoundException;

}
