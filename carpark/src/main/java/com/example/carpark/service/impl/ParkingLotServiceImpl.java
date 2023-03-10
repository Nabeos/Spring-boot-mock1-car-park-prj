package com.example.carpark.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carpark.entity.ParkingLot;
import com.example.carpark.entity.dto.parkinglot.ParkingLotCreationDTO;
import com.example.carpark.entity.dto.parkinglot.ParkingLotDTO;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.repository.ParkingLotRepository;
import com.example.carpark.service.ParkingLotService;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
  @Autowired
  private ParkingLotRepository repository;
  @Autowired
  private ModelMapper mapper;

  @Override
  public List<ParkingLotDTO> getParkingLotList(String searchName, String field, int offset, int limit) {
    List<ParkingLot> parkingLots = repository.findAll();
    return parkingLots.stream().map(p -> mapper.map(p, ParkingLotDTO.class)).collect(Collectors.toList());
  }

  @Override
  public void addParkingLot(ParkingLotCreationDTO creationDTO) {
    ParkingLot parkingLot = mapper.map(creationDTO, ParkingLot.class);
    parkingLot.setParkStatus("Blank");
    repository.save(parkingLot);
  }

  @Override
  public String deleteParkingLot(Long id) throws NotFoundException {
    ParkingLot parkingLot = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Parking Lot"));
    parkingLot.getCars().forEach(car -> {
      parkingLot.removeCar(car);
    });
    repository.delete(parkingLot);
    return "Delete successfully";
  }

  @Override
  public void updateParkingLot(ParkingLotCreationDTO dtoCreate, Long id) throws NotFoundException {
    ParkingLot parkingLot = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Parking Lot"));
    parkingLot.setParkArea(dtoCreate.getParkArea());
    parkingLot.setParkPrice(dtoCreate.getParkPrice());
    parkingLot.setParkPlace(dtoCreate.getParkPlace());
    parkingLot.setParkName(dtoCreate.getParkName());
    repository.save(parkingLot);
  }
}
