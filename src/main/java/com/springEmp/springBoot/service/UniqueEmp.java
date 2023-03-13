package com.springEmp.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.DuplicateKeyException;
import com.springEmp.springBoot.entity.Employee;
import com.springEmp.springBoot.repository.EmployeeRepository;

@Service
public class UniqueEmp {

	
	    

	    @Autowired
	    private MongoOperations mongoOperations;

	    public Employee createEmployee(Employee employee) {
	        Query query = new Query(Criteria.where("empCode").is(employee.getEmpCode()));
	        Employee existingEmployee = mongoOperations.findOne(query, Employee.class);
	        if (existingEmployee != null) {
	            throw new IllegalArgumentException("Employee with empCode " + employee.getEmpCode() + " already exists.");
	        }
	        return mongoOperations.save(employee);
	    }
	    
	    // other methods...
	}

	    
	    // other methods...
	

