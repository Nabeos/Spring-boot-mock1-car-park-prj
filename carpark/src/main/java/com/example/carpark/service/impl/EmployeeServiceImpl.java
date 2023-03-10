package com.example.carpark.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carpark.entity.Employee;
import com.example.carpark.entity.dto.employee.EmployeeCreationDTO;
import com.example.carpark.entity.dto.employee.EmployeeDTO;
import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;
import com.example.carpark.repository.EmployeeRepository;
import com.example.carpark.service.EmployeeService;
import com.example.carpark.utils.DateHelper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  private EmployeeRepository repository;
  @Autowired
  private ModelMapper model;
  private final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";

  @Override
  public void addEmployee(EmployeeCreationDTO dto) throws BadRequestCustomException {
    // make sure date is not in the future
    if (!DateHelper.checkDate(dto.getEmployeeBirthdate()))
      throw new BadRequestCustomException("Invalid Date of birth");
    // convert dto to domain model
    if (!dto.getPassword().matches(PASSWORD_REGEX))
      throw new BadRequestCustomException(
          "The password must have at least 6 characters, including uppercase, lowercase and number.");

    // check duplicate account, phone, email
    checkDuplicate(dto.getEmail(), dto.getAccount(), dto.getEmployeePhone());
    Employee employee = model.map(dto, Employee.class);
    if(employee.getEmployeeEmail().isBlank()) employee.setEmployeeEmail(null);
    repository.save(employee);
  }

  @Override
  public List<EmployeeDTO> displayEmployeeList(String searchName, String field, int offset, int limit) {
    // convert entity to dto
    return repository.findAllEmployee("%" + searchName + "%", field, offset, limit).stream()
        .map(e -> model.map(e, EmployeeDTO.class)).collect(Collectors.toList());
  }

  @Override
  public void updateEmployee(EmployeeCreationDTO employee, Long id) throws NotFoundException, BadRequestCustomException {
    checkDuplicate(employee.getEmail(), employee.getAccount(), employee.getEmployeePhone());
    Employee existedEmployee = getExistedEmployee(id);
    existedEmployee.setDepartment(employee.getDepartment());
    existedEmployee.setEmployeeAddress(employee.getEmployeeAddress());
    existedEmployee.setEmployeeBirthdate(employee.getEmployeeBirthdate());
    existedEmployee.setEmployeeEmail(employee.getEmail());
    existedEmployee.setEmployeeName(employee.getEmployeeName());
    existedEmployee.setEmployeePhone(employee.getEmployeePhone());
    existedEmployee.setSex(employee.getSex());

    repository.save(existedEmployee);
  }

  @Override
  public void deleteEmployee(Long id) throws NotFoundException {
    Employee existedEmployee = getExistedEmployee(id);
    repository.delete(existedEmployee);
  }

  @Override
  public Employee getExistedEmployee(Long id) throws NotFoundException {
    Employee existedEmployee = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Employee"));
    return existedEmployee;
  }

  // check duplicate of email, account and phone
  private void checkDuplicate(String email, String account, String phone) throws BadRequestCustomException{
    if (repository.findByAccount(account).orElse(null) != null) {
      throw new BadRequestCustomException("This account is already existed");
    }
    if (repository.findByEmployeePhone(phone).orElse(null) != null) {
      throw new BadRequestCustomException("This phone is already existed");
    }
    if (repository.findByEmployeeEmail(email).orElse(null) != null) {
      throw new BadRequestCustomException("This phone is already existed");
    }
  }
}
