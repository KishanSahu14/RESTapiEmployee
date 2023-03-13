package com.springEmp.springBoot.dto;







import org.slf4j.Logger;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.springEmp.springBoot.GlobalLogger.GlobLog;
import com.springEmp.springBoot.controller.MyController;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Document(collection="Emp")
public class EmployeeDto {
	
	
	
	@Id
    @Positive(message = "id must be a positive number")
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotEmpty(message = "address cannot be empty")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
