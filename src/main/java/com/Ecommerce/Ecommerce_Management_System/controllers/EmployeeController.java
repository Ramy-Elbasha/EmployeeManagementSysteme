package com.Ecommerce.Ecommerce_Management_System.controllers;

import com.Ecommerce.Ecommerce_Management_System.DTOs.EmployeeCreateDTO;
import com.Ecommerce.Ecommerce_Management_System.DTOs.EmployeeUpdateDTO;
import com.Ecommerce.Ecommerce_Management_System.abstracts.EmployeeSerivce;
import com.Ecommerce.Ecommerce_Management_System.entities.Employee;
import com.Ecommerce.Ecommerce_Management_System.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    private final EmployeeSerivce employeeService;

    public EmployeeController(EmployeeSerivce employeeSerivce) {
        this.employeeService = employeeSerivce;
    }


    @GetMapping("/hello")
    public String returnHello() {
        return "Hello from the other side";
    }

    @GetMapping("/dynamicParam/{name}")
    public String returnDynamic(@PathVariable String name) {
        return "Hello, " + name;

    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>> createOne(@RequestBody @Valid EmployeeCreateDTO emp) {
        Employee employee = employeeService.create(emp);
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Employee>>> findAll() {
        var allEmployees = employeeService.findAll();
        return new ResponseEntity<>(new GlobalResponse<>(allEmployees), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse<Employee>> findOne(@PathVariable UUID id) {
        var employee = employeeService.findOne(id);
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteOne(@PathVariable UUID id) {
        employeeService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponse<?>> updateOne(@PathVariable UUID id, @RequestBody EmployeeUpdateDTO reqEmp) {
        Employee employee = employeeService.updateOne(id, reqEmp);
        return new ResponseEntity<>(new GlobalResponse(employee), HttpStatus.OK);
    }
}
