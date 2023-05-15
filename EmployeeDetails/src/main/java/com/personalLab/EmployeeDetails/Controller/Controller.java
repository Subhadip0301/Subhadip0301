package com.personalLab.EmployeeDetails.Controller;


import com.personalLab.EmployeeDetails.Model.Employee;
import com.personalLab.EmployeeDetails.Service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {
   @Autowired
    private IEmployee iEmployee;
  @GetMapping("/allEmployees")
   public ResponseEntity<List<Employee>> getEmployee(){
      List<Employee> list=iEmployee.getAllEmployees();
      return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
   }
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
        Employee employee= iEmployee.getEmployeeById(employeeId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    @PostMapping("/employee")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee, UriComponentsBuilder builder ){
        boolean flag = iEmployee.addEmployee(employee);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(employee.getEmployeeId()).toUri());
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("employee")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee){
      iEmployee.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") long employeeId){
      iEmployee.deleteEmployee(employeeId);
      if(getEmployeeById(employeeId) == null){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(HttpStatus.OK);
    }
}
