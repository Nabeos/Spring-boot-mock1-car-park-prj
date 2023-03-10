package com.example.carpark.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.carpark.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  Optional<Employee> findByAccount(String account);

  Optional<Employee> findByEmployeePhone(String employeePhone);

  Optional<Employee> findByEmployeeEmail(String email);

  @Query(value = "SELECT * from Employee WHERE ?2 LIKE ?1 LIMIT ?3, ?4", nativeQuery = true)
  List<Employee> findAllEmployee(String searchName, String field, int offset, int limit);
}
