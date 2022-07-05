package com.example.demo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImple implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}




	@Override
	public String deleteEmployee() {
		// TODO Auto-generated method stub
		employeeRepository.deleteAll();
		return "deleted";
	}

	@Override
	public String deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		return "Deleted Successfully "+id;
	}
     //update details
	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id).get();
		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setEmailId(employee.getEmailId());
		existingEmployee.setRole(employee.getRole());
		return employeeRepository.save(existingEmployee);
	}


}



