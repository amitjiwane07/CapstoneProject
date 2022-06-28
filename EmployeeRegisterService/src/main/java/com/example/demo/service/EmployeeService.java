package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	
//	public Optional<Employee> getEmployeeById(Long id);

	public Employee findById(Long empId);
	
	public Employee saveEmployee(Employee employee);
	
	public String deleteEmployee();
	
	public String deleteEmployeeById(Long id);

	Employee updateEmployee(Long id,Employee employee);

	Employee saveEmployeeImage(Long id,MultipartFile file) throws IOException;
}
