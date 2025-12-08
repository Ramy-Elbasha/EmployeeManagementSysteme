package com.Ecommerce.Ecommerce_Management_System.entities;

import com.Ecommerce.Ecommerce_Management_System.DTOs.DepartmentCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "RESpringDepartment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    public Department(DepartmentCreateDTO dep) {
        this.name = dep.name();

    }

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;
}
