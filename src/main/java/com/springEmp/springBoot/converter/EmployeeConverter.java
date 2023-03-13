package com.springEmp.springBoot.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.springEmp.springBoot.GlobalLogger.GlobLog;
import com.springEmp.springBoot.controller.MyController;
import com.springEmp.springBoot.dto.EmployeeDto;
import com.springEmp.springBoot.entity.Employee;

@Component
public class EmployeeConverter {

	private Logger logger = GlobLog.getLogger(MyController.class);
	
    public EmployeeDto entityToDto(Employee employee) {
    	
    	String methodName="entityToDto";
		logger.info(methodName + "called");
    	
       EmployeeDto dto = new EmployeeDto();
       dto.setId(employee.getId());
       dto.setName(employee.getName());
       dto.setAddress(employee.getAddress());
       
       return dto;
    }
    
    public List<EmployeeDto> entityToDto(List<Employee> employee){
    	
    	return employee.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
    
    
    
    public Employee dtoToEntity(EmployeeDto dto) {
    	
    	String methodName="dtoToEntity()";
		logger.info(methodName + "called");
    	
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setAddress(dto.getAddress());
        return employee;
    

    }
    
    public List<Employee> dtoToEntity(List<EmployeeDto> dto)
    {
    	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
