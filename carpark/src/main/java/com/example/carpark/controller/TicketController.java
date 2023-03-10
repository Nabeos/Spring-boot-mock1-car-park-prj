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

import com.example.carpark.entity.dto.ticket.TicketCreationDTO;
import com.example.carpark.entity.dto.ticket.TicketDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.service.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/practice")
public class TicketController {
  @Autowired
  private TicketService service;

  @GetMapping("/tickets")
  public List<TicketDTO> displayTicketList(
      @RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
      @RequestParam(name = "limit", defaultValue = "8", required = true) int limit,
      @RequestParam(name = "searchField", defaultValue = "customerName", required = true) String field,
      @RequestParam(name = "searchValue", defaultValue = "", required = false) String searchName)
      throws NotFoundException {
    return service.getTicketList(searchName, field, offset, limit);
  }

  @PostMapping("/tickets")
  public ResponseEntity<String> addTicket(@RequestBody @Valid TicketCreationDTO dto)
      throws NotFoundException, BadRequestCustomException {
    service.addTicket(dto);
    return ResponseEntity.ok("Add ticket successfully");
  }

  @DeleteMapping("/delete-ticket")
  public String delete(@RequestParam Long id) throws NotFoundException {
    service.deleteTicket(id);
    return "Delete successfully";
  }

  @PutMapping("/tickets/{id}")
  public String updateTicket(@RequestBody @Valid TicketCreationDTO dtoCreate, @PathVariable Long id) throws NotFoundException {
    service.updateTicket(dtoCreate, id);
    return "Update successfully";
  }
}
