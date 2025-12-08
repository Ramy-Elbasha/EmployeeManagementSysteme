package com.Ecommerce.Ecommerce_Management_System.controllers;

import com.Ecommerce.Ecommerce_Management_System.DTOs.DepartmentCreateDTO;
import com.Ecommerce.Ecommerce_Management_System.abstracts.DepartmentService;
import com.Ecommerce.Ecommerce_Management_System.entities.Department;
import com.Ecommerce.Ecommerce_Management_System.shared.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Department>>> findAll() {
        return new ResponseEntity<>(new GlobalResponse<>(departmentService.findAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Department>> createOne(@RequestBody DepartmentCreateDTO department) {
        Department dep = departmentService.createOne(department);
        return new ResponseEntity<>(new GlobalResponse<>(dep), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Department> deleteOne(@PathVariable UUID id) {
        departmentService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse<Department>> findOne(@PathVariable UUID id) {
        return new ResponseEntity<>(new GlobalResponse<>(departmentService.findOne(id)), HttpStatus.OK);
    }
}
