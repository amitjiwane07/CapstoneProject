package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Optional<Employee> getEmployeeById(Long id);

    public Employee saveEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    public String deleteEmployee();

    public String deleteEmployeeById(Long id);

}
