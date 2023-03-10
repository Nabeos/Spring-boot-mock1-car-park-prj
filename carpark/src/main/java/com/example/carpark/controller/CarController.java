package com.example.carpark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.carpark.entity.dto.car.CarCreationDTO;
import com.example.carpark.entity.dto.car.CarDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/practice")
public class CarController {
  @Autowired
  private CarService service;

  @GetMapping("/cars")
  public List<CarDTO> displayBookingOfficeList(
      @RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
      @RequestParam(name = "limit", defaultValue = "8", required = true) int limit,
      @RequestParam(name = "searchField", defaultValue = "company", required = true) String field,
      @RequestParam(name = "searchValue", defaultValue = "", required = false) String searchName)
      throws NotFoundException {
    return service.getCarList(searchName, field, offset, limit);
  }

  @PostMapping("/cars")
  public ResponseEntity<String> addCar(@RequestBody @Valid CarCreationDTO creationDTO) {
    service.addCar(creationDTO);
    return ResponseEntity.ok("Add car successfully");
  }

  @DeleteMapping("/cars")
  public String delete(@RequestParam String licensePlate) throws NotFoundException, BadRequestCustomException {
    service.deleteCar(licensePlate);
    return "Delete successfully";
  }

  @PutMapping("/cars/{licensePlate}")
  public String updateCar(@RequestBody @Valid CarCreationDTO dtoCreate, @PathVariable String licensePlate) throws NotFoundException, BadRequestCustomException {
    service.updateCar(dtoCreate, licensePlate);
    return "Update successfully";
  }
}
