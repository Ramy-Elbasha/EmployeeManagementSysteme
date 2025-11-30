package com.Ecommerce.Ecommerce_Management_System.abstracts;

import com.Ecommerce.Ecommerce_Management_System.DTOs.EmployeeDTO;
import com.Ecommerce.Ecommerce_Management_System.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeSerivce {
    Employee findOne(UUID employeeId);

    List<Employee> findAll();

    void deleteOne(UUID employeeId);

    Employee updateOne(UUID employeeId, Employee employee);

    Employee create(EmployeeDTO emp);
}
