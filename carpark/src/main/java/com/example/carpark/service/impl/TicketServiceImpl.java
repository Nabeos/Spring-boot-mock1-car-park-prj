package com.example.carpark.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carpark.entity.Ticket;
import com.example.carpark.entity.Trip;
import com.example.carpark.entity.dto.ticket.TicketCreationDTO;
import com.example.carpark.entity.dto.ticket.TicketDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.repository.CarRepository;
import com.example.carpark.repository.TicketRepository;
import com.example.carpark.repository.TripRepository;
import com.example.carpark.repository.custom.TicketCustomRepository;
import com.example.carpark.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
  @Autowired
  private TicketRepository repository;
  @Autowired
  private CarRepository carRepository;
  @Autowired
  private TicketCustomRepository ticketCustomRepository;
  @Autowired
  private TripRepository tripRepository;
  @Autowired
  private ModelMapper model;

  @Override
  public List<TicketDTO> getTicketList(String searchName, String field, int offset, int limit) {
    List<Ticket> tickets = ticketCustomRepository.getAllTickets("%" + searchName + "%", field, offset, limit);
    return tickets.stream().map(t -> model.map(t, TicketDTO.class)).collect(Collectors.toList());
  }

  @Override
  public void deleteTicket(Long id) throws NotFoundException {
    Ticket ticket = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Ticket"));
    // find trip by id
    Trip trip = tripRepository.findById(ticket.getTrip().getTripId())
        .orElseThrow(() -> new NotFoundException("Not Found trip"));
    // minus 1 ticket in trip booked ticket
    ticket.getTrip().setBookedTicketNumber(trip.getBookedTicketNumber() - 1);
    repository.delete(ticket);
  }

  @Override
  public void addTicket(TicketCreationDTO dto) throws NotFoundException, BadRequestCustomException {
    // find trip by id
    Trip trip = tripRepository.findById(dto.getTripId()).orElseThrow(() -> new NotFoundException("Not Found trip"));

    // check whether slot is full
    if (trip.getBookedTicketNumber() == trip.getMaximumOnlineTicketNumber()) {
      throw new BadRequestCustomException("Full Slots, Try Again");
    }

    Ticket ticket = model.map(dto, Ticket.class);
    ticket.setCar(carRepository.getReferenceById(dto.getCarLicensePlate()));
    ticket.setTrip(tripRepository.getReferenceById(dto.getTripId()));
    repository.save(ticket);
  }

  @Override
  public void updateTicket(TicketCreationDTO dtoCreate, Long id) throws NotFoundException {
    Ticket ticket = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Ticket"));
    // check whether trip is existed
    if (ticket.getTrip() != null&&dtoCreate.getTripId() != null)
      tripRepository.findById(ticket.getTrip().getTripId()).orElseThrow(() -> new NotFoundException("Not Found trip"));
    // check whether car is null
    if (dtoCreate.getCarLicensePlate() != null)
      carRepository.findById(dtoCreate.getCarLicensePlate()).orElseThrow(() -> new NotFoundException("Not Found trip"));
    ticket.setBookingTime(dtoCreate.getBookingTime());
    ticket.setCustomerName(dtoCreate.getCustomerName());
    ticket.setCar(carRepository.getReferenceById(dtoCreate.getCarLicensePlate()));
    ticket.setTrip(tripRepository.getReferenceById(dtoCreate.getTripId()));
    repository.save(ticket);
  }
}
