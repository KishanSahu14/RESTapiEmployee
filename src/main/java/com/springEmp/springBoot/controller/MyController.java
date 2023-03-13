package com.springEmp.springBoot.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.springEmp.springBoot.converter.EmployeeConverter;
import com.springEmp.springBoot.dto.EmployeeDto;
import com.springEmp.springBoot.entity.Employee;
import com.springEmp.springBoot.service.EmployeeService;
import com.springEmp.springBoot.service.SequenceGeneratorService;

import jakarta.validation.Valid;


@RestController
@Slf4j
public class MyController {

    private EmployeeService employeeService;
    private SequenceGeneratorService sequenceGeneratorService;
    private EmployeeConverter converter;

    @Autowired
    public MyController(EmployeeService employeeService, SequenceGeneratorService sequenceGeneratorService, EmployeeConverter converter) {
       
        this.employeeService = employeeService;
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.converter = converter;
    }
    @PostMapping("/addEmp")
    public String saveEmp(@Valid @RequestBody Employee emp) {

        String methodName="saveEmp()";
        log.info(methodName + "called");

        Employee savedEmployee = employeeService.createEmployee(emp);
        return "Added employee with id: " + savedEmployee.getId();
    }

    @GetMapping("/findAllEmp")
    public List<EmployeeDto> getEmployees(){

        String methodName="getEmployees()";
        log.info(methodName + "called");
        List<Employee> employees = employeeService.getAllEmployees();
        return converter.entityToDto(employees);
    }

    @GetMapping("/findEmp/{id}")
	public EmployeeDto getEmployee(@PathVariable int id){
		String methodName="getEmployee()";
		log.info(methodName + "called");
		Employee employee = employeeService.getEmployeeById(id);
		return converter.entityToDto(employee);
	} 

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {

        String methodName="deleteEmployee()";
        log.info(methodName + "called");

        employeeService.deleteEmployee(id);
        return "Employee deleted with id: " + id;
    }

    @PutMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable int id, @Valid @RequestBody EmployeeDto empDto) {

        String methodName="updateEmp()";
        log.info(methodName + "called");

        Employee employee = converter.dtoToEntity(empDto);
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "Updated employee with id: " + employee.getId();
    }
}
