package com.example.springbootbackend.controller;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // to prevent CORS policy error
@RestController // No need @ResponseBody
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired // to inject this repository by spring container
    private EmployeeRepository employeeRepository;

    // get all emplolyees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id : " + id));
        return ResponseEntity.ok(employee);
    }
    // update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id : " + id));
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmailId(employee.getEmailId());

        Employee updatedEmployee = employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
