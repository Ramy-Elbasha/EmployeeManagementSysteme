package com.Ecommerce.Ecommerce_Management_System.abstracts;

import com.Ecommerce.Ecommerce_Management_System.DTOs.DepartmentCreateDTO;
import com.Ecommerce.Ecommerce_Management_System.entities.Department;

import java.util.List;
import java.util.UUID;


public interface DepartmentService {
    Department findOne(UUID departmentId);

    List<Department> findAll();

    Department createOne(DepartmentCreateDTO departmentId);

    void deleteOne(UUID departmentId);
}
