package com.example.carpark.repository.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.carpark.entity.Ticket;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class TicketCustomRepository {
  @Autowired
  private EntityManager em;

  public List<Ticket> getAllTickets(String searchName, String field, int offset, int limit) {
    String sql = "select c from Ticket c left join c.trip ct inner join c.car cc where " + field + " like :search";
    StringBuilder query = new StringBuilder(sql);

    TypedQuery<Ticket> ticket = em.createQuery(query.toString(), Ticket.class);
    ticket.setParameter("search", searchName);
    ticket.setFirstResult(offset);
    ticket.setMaxResults(limit);
    List<Ticket> ticketList = ticket.getResultList();
    return ticketList;
  }
}
