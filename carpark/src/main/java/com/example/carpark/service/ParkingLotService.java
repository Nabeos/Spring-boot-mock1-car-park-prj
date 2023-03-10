package com.example.carpark.service;

import java.util.List;

import com.example.carpark.entity.dto.parkinglot.ParkingLotCreationDTO;
import com.example.carpark.entity.dto.parkinglot.ParkingLotDTO;
import com.example.carpark.exception.custom.NotFoundException;

public interface ParkingLotService {

  List<ParkingLotDTO> getParkingLotList(String searchName, String field, int offset, int limit);

  void addParkingLot(ParkingLotCreationDTO creationDTO);

  String deleteParkingLot(Long id) throws NotFoundException;

  void updateParkingLot(ParkingLotCreationDTO dtoCreate, Long id) throws NotFoundException;

}
