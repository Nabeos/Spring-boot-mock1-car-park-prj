package com.example.carpark.service;

import java.util.List;

import com.example.carpark.entity.Employee;
import com.example.carpark.entity.dto.employee.EmployeeCreationDTO;
import com.example.carpark.entity.dto.employee.EmployeeDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;

public interface EmployeeService {

  void addEmployee(EmployeeCreationDTO employee) throws BadRequestCustomException;

  List<EmployeeDTO> displayEmployeeList(String searchName, String field, int offset, int limit);

  void updateEmployee(EmployeeCreationDTO employee, Long id) throws NotFoundException, BadRequestCustomException;

  void deleteEmployee(Long id) throws NotFoundException;

  Employee getExistedEmployee(Long id) throws NotFoundException;
}
