package com.springEmp.springBoot.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.SequenceGenerator;

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

@Document(collection="Emp")
public class Employee {
  
	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	
  @Id
  private int id;
   
   @Indexed(unique = true)
	private int empCode;
   
	@Min(value=30000, message="salary cannot be less than 30,000")
	@Max(value=50000, message="salary cannot be greater than 50,000")
	private int salary;
   
   @NotEmpty(message="name Cannot be blank")
   @Size(max=10, message="name Cannot be greater than 10")
	private String name;
   
   @NotEmpty(message="address Cannot be blank")
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empCode=" + empCode + ", salary=" + salary + ", name=" + name + ", address="
				+ address + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, int empCode, int salary, String name, String address) {
		super();
		this.id = id;
		this.empCode = empCode;
		this.salary = salary;
		this.name = name;
		this.address = address;
	}
}
