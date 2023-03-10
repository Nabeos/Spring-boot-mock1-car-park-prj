package com.example.carpark.repository.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.carpark.entity.Trip;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class TripCustomRepository {
  @Autowired
  private EntityManager em;

  public List<Trip> getAllTrips(String searchName, String field, int offset, int limit) {
    String sql = "select c from Trip c where " + field + " like :search";
    StringBuilder query = new StringBuilder(sql);

    TypedQuery<Trip> trips = em.createQuery(query.toString(), Trip.class);
    trips.setParameter("search", searchName);
    trips.setFirstResult(offset);
    trips.setMaxResults(limit);
    List<Trip> tripList = trips.getResultList();
    return tripList;
  }
}
