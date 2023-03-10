package com.example.carpark.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
@DynamicUpdate
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long employeeId;

  @Column(nullable = false)
  private String account;

  @Column(nullable = false)
  private String department;

  @Column(nullable = false)
  private String employeeName;
  private String employeeAddress;
  private String employeeBirthdate;
  private String employeeEmail;

  @Column(nullable = false)
  private String employeePhone;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String sex;

  public Employee() {
  }

  public Employee(Long employeeId, String account, String department, String employeeName, String employeeAddress,
      String employeeBirthdate, String employeeEmail, String employeePhone, String password, String sex) {
    this.employeeId = employeeId;
    this.account = account;
    this.department = department;
    this.employeeName = employeeName;
    this.employeeAddress = employeeAddress;
    this.employeeBirthdate = employeeBirthdate;
    this.employeeEmail = employeeEmail;
    this.employeePhone = employeePhone;
    this.password = password;
    this.sex = sex;
  }

  public double getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmployeeAddress() {
    return employeeAddress;
  }

  public void setEmployeeAddress(String employeeAddress) {
    this.employeeAddress = employeeAddress;
  }

  public String getEmployeeBirthdate() {
    return employeeBirthdate;
  }

  public void setEmployeeBirthdate(String employeeBirthdate) {
    this.employeeBirthdate = employeeBirthdate;
  }

  public String getEmployeeEmail() {
    return employeeEmail;
  }

  public void setEmployeeEmail(String employeeEmail) {
    this.employeeEmail = employeeEmail;
  }

  public String getEmployeePhone() {
    return employeePhone;
  }

  public void setEmployeePhone(String employeePhone) {
    this.employeePhone = employeePhone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

}
