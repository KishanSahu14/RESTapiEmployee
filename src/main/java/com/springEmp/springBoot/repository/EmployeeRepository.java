package com.springEmp.springBoot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springEmp.springBoot.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,Integer>{

}
