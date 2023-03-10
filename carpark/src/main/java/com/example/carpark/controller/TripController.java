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

import com.example.carpark.entity.dto.trip.TripCreationDTO;
import com.example.carpark.entity.dto.trip.TripDTO;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.service.TripService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/practice")
public class TripController{
  @Autowired
  private TripService service;

  @GetMapping("/trips")
  public List<TripDTO> displayTripList(
      @RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
      @RequestParam(name = "limit", defaultValue = "8", required = true) int limit,
      @RequestParam(name = "searchField", defaultValue = "destination", required = true) String field,
      @RequestParam(name = "searchValue", defaultValue = "", required = false) String searchName)
      throws NotFoundException {
    return service.getTripList(searchName, field, offset, limit);
  }

  @PostMapping("/trips")
  public ResponseEntity<String> addTrip(@RequestBody @Valid TripCreationDTO dto) {
    service.addTrip(dto);
    return ResponseEntity.ok("Add trip successfully");
  }

  @DeleteMapping("/trips")
  public String delete(@RequestParam Long id) throws NotFoundException {
    service.deleteTrip(id);
    return "Delete successfully";
  }

  @PutMapping("/trips/{id}")
  public String updateTrip(@RequestBody @Valid TripCreationDTO dtoCreate, @PathVariable Long id) throws NotFoundException {
    service.updateTrip(dtoCreate, id);
    return "Update successfully";
  }
}
