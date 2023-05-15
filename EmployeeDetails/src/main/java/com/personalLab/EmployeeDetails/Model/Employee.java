package com.personalLab.EmployeeDetails.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
  @Id
  @Column(name="employee_id")
  private Long employeeId;
  @Column(name="firstName")
    private String firstName;
  @Column(name="lastName")
    private String lastName;
  @Column(name="phoneNum")
    private int phoneNum;
  @Column(name="email")
    private String email;
    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }
}
