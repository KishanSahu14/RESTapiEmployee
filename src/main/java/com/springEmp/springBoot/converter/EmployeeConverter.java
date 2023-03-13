package com.springEmp.springBoot.converter;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.springEmp.springBoot.dto.EmployeeDto;
import com.springEmp.springBoot.entity.Employee;

@Slf4j
@Component
public class EmployeeConverter {

    public EmployeeDto entityToDto(Employee employee) {
        String methodName = "entityToDto";
        log.info("{} called", methodName);

        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAddress(employee.getAddress());

        return dto;
    }

    public List<EmployeeDto> entityToDto(List<Employee> employee) {
        return employee.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Employee dtoToEntity(EmployeeDto dto) {
        String methodName = "dtoToEntity()";
        log.info("{} called", methodName);

        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setAddress(dto.getAddress());

        return employee;
    }

    public List<Employee> dtoToEntity(List<EmployeeDto> dto) {
        return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}