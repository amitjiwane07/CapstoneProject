package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.serviceImple.EmployeeServiceImple;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeServiceImple employeeServiceImple;

//	@Autowired
//	private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/{id}")
    public Employee findByEmployeeId(@PathVariable("id") Long empId) {
        return employeeServiceImple.findById(empId);
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


    // ************** IMAGE UPLOAD *************

//	@PostMapping("/upload")
//	public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
//
//		Employee employee = null;
//		employee = employeeService.saveEmployeeImage(file);
//
//		return new ResponseData(employee.getFileName(),
//				file.getContentType(),
//				file.getSize());
//
//	}


    @PutMapping(value = "/upload/{id}")
    public String uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {

        String returnValue = "start";

        try {
            employeeService.saveEmployeeImage(id, file);
            returnValue = "Image saved";

        } catch (IOException e) {
            e.printStackTrace();
            returnValue = "error";
        }
        return returnValue;
    }


    @PutMapping("/{id}")
    public Employee employeeUpdate(@PathVariable("id") long empId, @RequestBody Employee employee) {

        return employeeServiceImple.updateEmployee(empId, employee);
    }
    

	@GetMapping("/getAll")
	public List<Employee> obtainAllEmployee() {
		return employeeServiceImple.getAllEmployee();
	}

	@GetMapping("/get/{id}")
	public Optional<Employee> obtainEmployeeById(@PathVariable Long id) {
		return employeeServiceImple.getEmployeeById(id);
	}




	@PutMapping("/update/{id}")
	public Employee modifyEmployee(@PathVariable Long id, @RequestBody Employee employee){
		return employeeServiceImple.updateEmployee(id, employee);
	}


}


