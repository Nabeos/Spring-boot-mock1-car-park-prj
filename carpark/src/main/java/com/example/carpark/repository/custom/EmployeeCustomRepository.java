package com.example.carpark.repository.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.carpark.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class EmployeeCustomRepository {
  @Autowired
  private EntityManager em;

  public List<Employee> getAllEmployee(String searchName, String field, int offset, int limit) {
    String sql = "select c from Employee c where " + field + " like :search";
    StringBuilder query = new StringBuilder(sql);

    TypedQuery<Employee> employees = em.createQuery(query.toString(), Employee.class);
    employees.setParameter("search", searchName);
    employees.setFirstResult(offset);
    employees.setMaxResults(limit);
    List<Employee> employeeList = employees.getResultList();
    return employeeList;
  }
}
