package com.Ecommerce.Ecommerce_Management_System.entities;

import com.Ecommerce.Ecommerce_Management_System.DTOs.EmployeeCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "RESpringEmployee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "AGE", length = 3)
    private short age;

    @Column(name = "PHONE_NUMBER", length = 14)
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private LocalDate hireDate;

    @Column(name = "POSITION", length = 50)
    private String position;

    @Column(name = "DEPARTMENT_ID")
    private UUID departmentId;


    public Employee(EmployeeCreateDTO emp) {

        this.firstName = emp.firstName();
        this.lastName = emp.lastName();
        this.position = emp.position();
        this.email = emp.email();
        this.phoneNumber = emp.phoneNumber();
        this.age = emp.age();
        this.departmentId = UUID.randomUUID();
    }
}
