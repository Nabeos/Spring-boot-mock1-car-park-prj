package com.example.carpark.service;

import java.util.List;

import com.example.carpark.entity.dto.ticket.TicketCreationDTO;
import com.example.carpark.entity.dto.ticket.TicketDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;

public interface TicketService {

  List<TicketDTO> getTicketList(String searchName, String field, int offset, int limit);

  void addTicket(TicketCreationDTO dto) throws NotFoundException, BadRequestCustomException;

  void deleteTicket(Long id) throws NotFoundException;

  void updateTicket(TicketCreationDTO dtoCreate, Long id) throws NotFoundException;
}
