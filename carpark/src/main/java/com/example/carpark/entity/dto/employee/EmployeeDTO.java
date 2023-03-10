package com.example.carpark.entity.dto.employee;

public class EmployeeDTO {
  private Long employeeId;
  private String employeeName;
  private String employeeBirthdate;
  private String employeeAddress;
  private String employeePhone;
  private String department;

  public EmployeeDTO() {
  }

  public EmployeeDTO(Long employeeId, String employeeName, String employeeBirthdate, String employeeAddress,
      String employeePhone, String department) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.employeeBirthdate = employeeBirthdate;
    this.employeeAddress = employeeAddress;
    this.employeePhone = employeePhone;
    this.department = department;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmployeeBirthdate() {
    return employeeBirthdate;
  }

  public void setEmployeeBirthdate(String employeeBirthdate) {
    this.employeeBirthdate = employeeBirthdate;
  }

  public String getEmployeeAddress() {
    return employeeAddress;
  }

  public void setEmployeeAddress(String employeeAddress) {
    this.employeeAddress = employeeAddress;
  }

  public String getEmployeePhone() {
    return employeePhone;
  }

  public void setEmployeePhone(String employeePhone) {
    this.employeePhone = employeePhone;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

}
