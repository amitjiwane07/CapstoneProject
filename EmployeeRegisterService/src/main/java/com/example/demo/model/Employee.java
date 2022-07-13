package com.example.demo.model;

import javax.persistence.*;
import java.nio.file.FileStore;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String empName;
    private String department;
    private String emailId;
    private String fileName;
    private String filePath;

    public Employee(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

//	public Employee(String fileName, String contentType, byte[] bytes) {
//		super();
//		// TODO Auto-generated constructor stub
//	}

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Employee(Long empId, String empName, String department, String emailId, Role role) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.emailId = emailId;
        this.role = role;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", department='" + department + '\'' +
                ", emailId='" + emailId + '\'' +
                ", role=" + role +
                '}';
    }
}
