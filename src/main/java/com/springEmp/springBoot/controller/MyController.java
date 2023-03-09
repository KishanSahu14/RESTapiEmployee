package com.springEmp.springBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springEmp.springBoot.entity.Employee;
import com.springEmp.springBoot.repository.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
public class MyController {

	@Autowired
	private EmployeeRepository employeerepository;
	
	@PostMapping("/addEmp")
	public String saveEmp(@Valid @RequestBody Employee emp) {
		employeerepository.save(emp);
		return "Added employee with id: " + emp.getId();
	}
	
	@GetMapping("/findAllEmp")
	public List<Employee> getEmployees(){
		return employeerepository.findAll();
	}
	
	@GetMapping("/findEmp/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id){
		
		return employeerepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeerepository.deleteById(id);
		return"Employee deleted with id :" + id;
	}
	
}
