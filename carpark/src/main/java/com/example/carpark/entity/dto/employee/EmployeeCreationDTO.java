package com.example.carpark.entity.dto.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeCreationDTO {
  @NotBlank(message = "Full name is mandatory")
  private String employeeName;
  @NotBlank(message = "Phone is mandatory")
  private String employeePhone;
  @NotBlank(message = "DOB is mandatory")
  @Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/([19, 20]{2})?([0-9]{2})", message = "Invalid DOB, Must be dd/MM/yyyy format")
  private String employeeBirthdate;

  @NotBlank(message = "Gender is mandatory")
  @Size(min = 1, max = 1, message = "Must be 1 character")
  @Pattern(regexp = "^(m|f)$", message = "Only one character m or f")
  private String sex;
  private String employeeAddress;
  private String email;
  @NotBlank(message = "Account is mandatory")
  @Pattern(regexp = "^[0-9a-zA-Z]{6,12}$", message = "Invalid account, between 6 - 12 characters")
  private String account;
  @NotBlank(message = "Password is mandatory")
  private String password;
  @NotBlank(message = "Department is mandatory")
  private String department;

  public EmployeeCreationDTO() {
  }

  public EmployeeCreationDTO(String employeeName, String employeePhone, String employeeBirthdate, String sex,
      String employeeAddress, String email, String account, String password, String department) {
    this.employeeName = employeeName;
    this.employeePhone = employeePhone;
    this.employeeBirthdate = employeeBirthdate;
    this.sex = sex;
    this.employeeAddress = employeeAddress;
    this.email = email;
    this.account = account;
    this.password = password;
    this.department = department;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmployeePhone() {
    return employeePhone;
  }

  public void setEmployeePhone(String employeePhone) {
    this.employeePhone = employeePhone;
  }

  public String getEmployeeBirthdate() {
    return employeeBirthdate;
  }

  public void setEmployeeBirthdate(String employeeBirthdate) {
    this.employeeBirthdate = employeeBirthdate;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getEmployeeAddress() {
    return employeeAddress;
  }

  public void setEmployeeAddress(String employeeAddress) {
    this.employeeAddress = employeeAddress;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

}
