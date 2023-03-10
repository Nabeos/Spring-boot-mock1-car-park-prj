package com.example.carpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carpark.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
