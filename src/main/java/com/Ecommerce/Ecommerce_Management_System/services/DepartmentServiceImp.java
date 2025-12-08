package com.Ecommerce.Ecommerce_Management_System.services;

import com.Ecommerce.Ecommerce_Management_System.DTOs.DepartmentCreateDTO;
import com.Ecommerce.Ecommerce_Management_System.abstracts.DepartmentService;
import com.Ecommerce.Ecommerce_Management_System.entities.Department;
import com.Ecommerce.Ecommerce_Management_System.repositories.DepartmentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImp implements DepartmentService {
    DepartmentRepo departmentRepo;

    public DepartmentServiceImp(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public Department findOne(UUID departmentId) {
        return departmentRepo.findById(departmentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department createOne(DepartmentCreateDTO department) {
        Department dep = new Department(department);
        return departmentRepo.save(dep);
    }

    @Override
    public void deleteOne(UUID departmentId) {
        departmentRepo.deleteById(departmentId);
    }
}


