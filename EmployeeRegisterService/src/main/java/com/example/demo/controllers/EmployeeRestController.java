package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.serviceImple.EmployeeServiceImple;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeServiceImple employeeServiceImple;
	
	@GetMapping("/getAll")
	public List<Employee> obtainAllEmployee(){
		return employeeServiceImple.getAllEmployee();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Employee> obtainEmployeeById(@PathVariable Long id){
		return employeeServiceImple.getEmployeeById(id);
	}
	
	@PostMapping("/post")
	public Employee storeEmployee(@RequestBody Employee employee) {
		return employeeServiceImple.saveEmployee(employee);
	}
     
	@DeleteMapping("/deleteAll")
	public String eraseEmployee() {
		employeeServiceImple.deleteEmployee();
		return "Deleted Successfully";
	}
	
	@DeleteMapping("/delete/{id}")
	public String eraseEmployeeById(@PathVariable Long id) {
		employeeServiceImple.deleteEmployeeById(id);
		return "Deleted " + id;
	}
}
