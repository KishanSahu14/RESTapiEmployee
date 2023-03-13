package com.springEmp.springBoot.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Emp")
public class EmployeeDto {

    @Id
    @NotNull(message = "id cannot be null")
    private String id;

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotEmpty(message = "address cannot be empty")
    private String address;

}
