package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.serviceImple.EmployeeServiceImple;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeServiceImple employeeServiceImple;

	@GetMapping("/getAll")
	public List<Employee> obtainAllEmployee() {
		return employeeServiceImple.getAllEmployee();
	}

	@GetMapping("/get/{id}")
	public Optional<Employee> obtainEmployeeById(@PathVariable Long id) {
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

	@PutMapping("/update/{id}")
	public Employee modifyEmployee(@PathVariable Long id, @RequestBody Employee employee){
		return employeeServiceImple.updateEmployee(id, employee);
	}


}
