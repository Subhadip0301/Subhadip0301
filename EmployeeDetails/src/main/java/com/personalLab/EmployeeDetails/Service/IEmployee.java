package com.personalLab.EmployeeDetails.Service;



import com.personalLab.EmployeeDetails.Model.Employee;

import java.util.List;

public interface IEmployee {
        List<Employee> getAllEmployees();
        Employee getEmployeeById(long employeeId);
        boolean addEmployee(Employee employee);
        void updateEmployee(Employee employee);
        void deleteEmployee(long employeeId);
}
