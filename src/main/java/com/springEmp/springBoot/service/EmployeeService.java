package com.springEmp.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springEmp.springBoot.GlobalLogger.GlobLog;
import com.springEmp.springBoot.controller.MyController;
import com.springEmp.springBoot.entity.Employee;
import com.springEmp.springBoot.exceptions.EmployeeNotFoundException;
import com.springEmp.springBoot.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class EmployeeService {
	
	//private Logger logger = GlobLog.getLogger(MyController.class);
	
	@Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
    	
    	log.info("createEmployee() called");
    	
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        log.info("getEmployeeById() called");

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
    }


    public List<Employee> getAllEmployees() {
    	log.info("getAllEmployees() called");
    
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
    	
    	log.info("updateEmployee() called");
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
    	
    	log.info("deleteEmployee() called");
        employeeRepository.deleteById(id);
    }
}
