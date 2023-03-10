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

import com.example.carpark.entity.dto.parkinglot.ParkingLotCreationDTO;
import com.example.carpark.entity.dto.parkinglot.ParkingLotDTO;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.service.ParkingLotService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/practice")
public class ParkingLotController {
  @Autowired
  private ParkingLotService service;


  @GetMapping("/parking-lots")
  public List<ParkingLotDTO> displayParkingLotList(
      @RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
      @RequestParam(name = "limit", defaultValue = "8", required = true) int limit,
      @RequestParam(name = "searchField", defaultValue = "parkName", required = true) String field,
      @RequestParam(name = "searchValue", defaultValue = "", required = false) String searchName)
      throws NotFoundException {
    return service.getParkingLotList(searchName, field, offset, limit);
  }

  @PostMapping("/parking-lots")
  public ResponseEntity<String> addParkingLot(@RequestBody @Valid ParkingLotCreationDTO creationDTO){
    service.addParkingLot(creationDTO);
    return ResponseEntity.ok("Add parking lot successfully");
  }

  @DeleteMapping("/parking-lots")
  public String addParkingLot(@RequestParam Long id) throws NotFoundException{
    return service.deleteParkingLot(id);
  }

  @PutMapping("/parking-lots/{id}")
  public String updateParkingLot(@RequestBody @Valid ParkingLotCreationDTO dtoCreate, @PathVariable Long id) throws NotFoundException {
    service.updateParkingLot(dtoCreate, id);
    return "Update successfully";
  }
}
