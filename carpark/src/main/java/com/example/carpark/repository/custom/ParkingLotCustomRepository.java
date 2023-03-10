package com.example.carpark.repository.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.carpark.entity.ParkingLot;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class ParkingLotCustomRepository {
  @Autowired
  private EntityManager em;

  public List<ParkingLot> getAllParkingLots(String searchName, String field, int offset, int limit) {
    String sql = "select c from ParkingLot c where " + field + " like :search";
    StringBuilder query = new StringBuilder(sql);

    TypedQuery<ParkingLot> parkingLots = em.createQuery(query.toString(), ParkingLot.class);
    parkingLots.setParameter("search", searchName);
    parkingLots.setFirstResult(offset);
    parkingLots.setMaxResults(limit);
    List<ParkingLot> parkingLotList = parkingLots.getResultList();
    return parkingLotList;
  }
}
