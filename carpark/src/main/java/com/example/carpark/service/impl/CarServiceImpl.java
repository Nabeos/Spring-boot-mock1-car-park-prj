package com.example.carpark.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carpark.entity.Car;
import com.example.carpark.entity.dto.car.CarCreationDTO;
import com.example.carpark.entity.dto.car.CarDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.repository.CarRepository;
import com.example.carpark.repository.ParkingLotRepository;
import com.example.carpark.repository.custom.CarCustomRepository;
import com.example.carpark.service.CarService;

@Service
public class CarServiceImpl implements CarService {
  @Autowired
  private CarRepository repository;
  @Autowired
  private CarCustomRepository carCriteria;
  @Autowired
  private ParkingLotRepository parkingLotRepository;
  @Autowired
  private ModelMapper model;

  @Override
  public List<CarDTO> getCarList(String searchName, String field, int offset, int limit) {
    List<Car> cars = carCriteria.getAllCars("%" + searchName + "%", field, offset, limit);
    return cars.stream().map(c -> model.map(c, CarDTO.class)).collect(Collectors.toList());
  }

  @Override
  public void addCar(CarCreationDTO creationDTO) {
    Car car = model.map(creationDTO, Car.class);
    car.setParkingLot(parkingLotRepository.getReferenceById(creationDTO.getParkId()));
    repository.save(car);
  }

  @Override
  public void updateCar(CarCreationDTO dtoCreate, String licensePlate)
      throws NotFoundException, BadRequestCustomException {
    Car car = repository.findById(licensePlate).orElseThrow(() -> new NotFoundException("Not found Car"));
    // check whether parking lot is existed
    if (dtoCreate.getParkId() != null)
      parkingLotRepository.findById(dtoCreate.getParkId())
          .orElseThrow(() -> new NotFoundException("Not Found Parking lot"));
    // check duplicate license plate
    repository.findById(dtoCreate.getLicensePlate())
        .orElseThrow(() -> new BadRequestCustomException("Already existed"));
    // setter
    car.setLicensePlate(dtoCreate.getLicensePlate());
    car.setCarColor(dtoCreate.getCarColor());
    car.setCarType(dtoCreate.getCarType());
    car.setCompany(dtoCreate.getCompany());
    car.setParkingLot(parkingLotRepository.getReferenceById(dtoCreate.getParkId()));

    repository.save(car);
  }

  @Override
  public void deleteCar(String licensePlate) throws NotFoundException, BadRequestCustomException {
    Car car = repository.findById(licensePlate).orElseThrow(() -> new NotFoundException("Not found Car"));
    if (!car.getTickets().isEmpty() || car.getTickets() == null)
      throw new BadRequestCustomException("Can not delete because already booked");
    repository.delete(car);
  }

}
