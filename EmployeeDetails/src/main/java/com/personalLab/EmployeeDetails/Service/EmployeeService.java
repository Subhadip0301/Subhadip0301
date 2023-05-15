package com.personalLab.EmployeeDetails.Service;



import com.personalLab.EmployeeDetails.Model.Employee;
import com.personalLab.EmployeeDetails.Model.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployee {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        employeeRepo.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        return employeeRepo.findById(employeeId).get();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return true;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepo.deleteById(employeeId);
    }
}
