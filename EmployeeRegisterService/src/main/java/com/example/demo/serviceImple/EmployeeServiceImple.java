package com.example.demo.serviceImple;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeServiceImple implements EmployeeService {
  
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long empId) {
        return employeeRepository.findEmployeeByEmpId(empId);
    }

//	@Override
//	public Optional<Employee> getEmployeeById(Long id) {
//
//			// TODO Auto-generated method stub
//		return employeeRepository.findById(id);
//	}

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
        return "Deleted Successfully " + id;
    }
// ************* IMAGE UPLOAD*************

//	@Override
//	public Employee saveEmployeeImage(MultipartFile file) throws Exception {
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());  //-----------------------------------
//		try{
//			if(fileName.contains("..")) {
//				throw new Exception("File name contains invalid path sequence" + fileName);
//			}
//
//			Employee employee = new Employee(fileName,file.getContentType(),file.getBytes());
//			return employeeRepository.save(employee);
//		}
//		catch (Exception e) {
//			throw new Exception("Could not save file : " + fileName);
//		}
//	}

    @Override
    public Employee saveEmployeeImage(Long empId, MultipartFile file) throws IOException {
        Employee employee1 = employeeRepository.findEmployeeByEmpId(empId);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String folder = "D:\\photos1\\";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder + file.getOriginalFilename());
        Files.write(path, bytes);
        employee1.setFileName(fileName);
        employee1.setFilePath(folder + fileName);
        return employeeRepository.save(employee1);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        employee.setEmpId(id);
        return employeeRepository.save(employee);
    }



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


