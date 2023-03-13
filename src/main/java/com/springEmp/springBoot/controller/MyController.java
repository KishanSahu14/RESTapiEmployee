package com.springEmp.springBoot.controller;
import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springEmp.springBoot.GlobalLogger.GlobLog;
import com.springEmp.springBoot.converter.EmployeeConverter;
import com.springEmp.springBoot.dto.EmployeeDto;
import com.springEmp.springBoot.entity.Employee;
import com.springEmp.springBoot.repository.EmployeeRepository;
import com.springEmp.springBoot.service.SequenceGeneratorService;

import jakarta.validation.Valid;

@RestController
public class MyController {
	
	private Logger logger = GlobLog.getLogger(MyController.class);

	@Autowired
	private EmployeeRepository employeerepository;
	@Autowired
	private SequenceGeneratorService service;
	@Autowired
	private EmployeeConverter converter;
	
	@PostMapping("/addEmp")
	public String saveEmp(@Valid @RequestBody Employee emp) {
		
		String methodName="saveEmp()";
		logger.info(methodName + "called");
		
		emp.setId(service.getSequenceNumber(emp.SEQUENCE_NAME));
		employeerepository.save(emp);
		return "Added employee with id: " + emp.getId();
	}
	
	@GetMapping("/findAllEmp")
	public List<EmployeeDto> getEmployees(){
		
		String methodName="getEmployees()";
		logger.info(methodName + "called");
		List<Employee> employees = employeerepository.findAll();
		return converter.entityToDto(employees);
	}
	
	@GetMapping("/findEmp/{id}")
	public EmployeeDto getEmployee(@PathVariable int id){
		String methodName="getEmployee()";
		logger.info(methodName + "called");
		Optional<Employee> employee = employeerepository.findById(id);
		return employee.map(converter::entityToDto).orElse(null);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		String methodName="deleteEmployee()";
		logger.info(methodName + "called");
		employeerepository.deleteById(id);
		return "Employee deleted with id: " + id;
	}
	@PutMapping("/updateEmp/{id}")
	public String updateEmp(@PathVariable int id, @Valid @RequestBody EmployeeDto empDto) {
		
		String methodName="updateEmp()";
		logger.info(methodName + "called");
		
		Optional<Employee> employeeOptional = employeerepository.findById(id);
		if (employeeOptional.isPresent()) {
			Employee emp = employeeOptional.get();
			emp.setName(empDto.getName());
			emp.setAddress(empDto.getAddress());
			employeerepository.save(emp);
			return "Updated employee with id: " + emp.getId();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
		}
}
}
