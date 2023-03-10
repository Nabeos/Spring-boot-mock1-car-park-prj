package com.example.carpark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.carpark.entity.dto.employee.EmployeeCreationDTO;
import com.example.carpark.entity.dto.employee.EmployeeDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/practice")
public class EmployeeController {
  @Autowired
  private EmployeeService service;

  @PostMapping("/employees")
  public String addEmployee(@RequestBody @Valid EmployeeCreationDTO employee) throws BadRequestCustomException {
    service.addEmployee(employee);
    return "Add Employee Successfully";
  }

  @PutMapping("/employees/{id}")
  public String updateEmployee(@RequestBody @Valid EmployeeCreationDTO employee, @PathVariable Long id)
      throws BadRequestCustomException, NotFoundException {
    service.updateEmployee(employee, id);
    return "Update Employee Successfully";
  }

  @GetMapping("/employees")
  public List<EmployeeDTO> displayEmployeeList(
      @RequestParam(name = "offset", defaultValue = "0", required = true) int offset,
      @RequestParam(name = "limit", defaultValue = "8", required = true) int limit,
      @RequestParam(name = "searchField", defaultValue = "employeeName", required = true) String field,
      @RequestParam(name = "searchValue", defaultValue = "", required = false) String searchName)
      throws NotFoundException {
    return service.displayEmployeeList(searchName, field, offset, limit);
  }

  @DeleteMapping("/employees")
  public String delete(@RequestParam Long id) throws NotFoundException {
    service.deleteEmployee(id);
    return "Delete successfully";
  }

}
