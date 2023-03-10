package com.example.carpark.service;

import java.util.List;

import com.example.carpark.entity.dto.car.CarCreationDTO;
import com.example.carpark.entity.dto.car.CarDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;

public interface CarService {

  List<CarDTO> getCarList(String searchName, String field, int offset, int limit);

  void addCar(CarCreationDTO creationDTO);

  void updateCar(CarCreationDTO dtoCreate, String licensePlate) throws NotFoundException, BadRequestCustomException;

  void deleteCar(String licensePlate) throws NotFoundException, BadRequestCustomException;

}
