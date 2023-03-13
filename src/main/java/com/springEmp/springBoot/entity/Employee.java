package com.springEmp.springBoot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Emp")
public class Employee {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private String id;

    @Indexed(unique = true)
    private int empCode;

    @Min(value = 30000, message = "salary cannot be less than 30,000")
    @Max(value = 50000, message = "salary cannot be greater than 50,000")
    private int salary;

    @NotEmpty(message = "name Cannot be blank")
    @Size(max = 10, message = "name Cannot be greater than 10")
    private String name;

    @NotEmpty(message = "address Cannot be blank")
    private String address;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", empCode=" + empCode + ", salary=" + salary + ", name=" + name + ", address="
                + address + "]";
    }
}
