package com.Ecommerce.Ecommerce_Management_System.entities;

import com.Ecommerce.Ecommerce_Management_System.DTOs.EmployeeDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private UUID id;
    @NotNull(message = "first name is required")
    private String firstName;
    private String lastName;
    private String email;
    private short age;
    private String phoneNumber;
    private LocalDate hireDate;
    private String position;
    private UUID departmentId;

    public Employee() {
    }

    public Employee(EmployeeDTO emp) {
        this.firstName = emp.getFirstName();
        this.lastName = emp.getLastName();
        this.position = emp.getPosition();
        this.phoneNumber = emp.getPhone();
        this.age = emp.getAge();
        this.email = emp.getEmail();
        this.id = UUID.randomUUID();
        this.departmentId = UUID.randomUUID();


    }
}