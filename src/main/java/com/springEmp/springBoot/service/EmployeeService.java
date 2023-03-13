package com.springEmp.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springEmp.springBoot.GlobalLogger.GlobLog;
import com.springEmp.springBoot.controller.MyController;
import com.springEmp.springBoot.entity.Employee;
import com.springEmp.springBoot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private Logger logger = GlobLog.getLogger(MyController.class);
	
	@Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
    	
    	logger.info("createEmployee() called");
    	
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
    	logger.info("getEmployeeById() called");
    	
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.isPresent() ? employee.get() : null;
    }

    public List<Employee> getAllEmployees() {
    	logger.info("getAllEmployees() called");
    
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
    	
    	logger.info("updateEmployee() called");
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
    	
    	logger.info("deleteEmployee() called");
        employeeRepository.deleteById(id);
    }
}
