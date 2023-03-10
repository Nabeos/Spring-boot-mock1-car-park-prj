package com.example.carpark.repository.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.carpark.entity.Car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class CarCustomRepository {
  @Autowired
  private EntityManager em;

  public List<Car> getAllCars(String searchName, String field, int offset, int limit) {
    String sql = "select c from Car c left join c.parkingLot cp where " + field + " like :search";
    StringBuilder query = new StringBuilder(sql);

    TypedQuery<Car> cars = em.createQuery(query.toString(), Car.class);
    cars.setParameter("search", searchName);
    cars.setFirstResult(offset);
    cars.setMaxResults(limit);
    List<Car> carList = cars.getResultList();
    return carList;
  }
}
