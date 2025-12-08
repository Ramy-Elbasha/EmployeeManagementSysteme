package com.Ecommerce.Ecommerce_Management_System.services;

import com.Ecommerce.Ecommerce_Management_System.DTOs.EmployeeCreateDTO;
import com.Ecommerce.Ecommerce_Management_System.DTOs.EmployeeUpdateDTO;
import com.Ecommerce.Ecommerce_Management_System.abstracts.EmployeeSerivce;
import com.Ecommerce.Ecommerce_Management_System.entities.Department;
import com.Ecommerce.Ecommerce_Management_System.entities.Employee;
import com.Ecommerce.Ecommerce_Management_System.repositories.DepartmentRepo;
import com.Ecommerce.Ecommerce_Management_System.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImp implements EmployeeSerivce {
    private final EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
//    List<Employee> emps = new ArrayList<Employee>(
//            List.of(
//                    new Employee(UUID.randomUUID(), "Ramy", "Elbasha", "ramy.elbasha@example.com", (short) 15, "0100000001", LocalDate.of(2025, 8, 12), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Ahmed", "Hassan", "ahmed.hassan@example.com", (short) 15, "0100000002", LocalDate.of(2025, 5, 20), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Sara", "Mahmoud", "sara.mahmoud@example.com", (short) 15, "0100000003", LocalDate.of(2025, 3, 15), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Laila", "Khaled", "laila.khaled@example.com", (short) 15, "0100000004", LocalDate.of(2025, 1, 30), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Omar", "Ali", "omar.ali@example.com", (short) 15, "0100000005", LocalDate.of(2025, 6, 5), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Nour", "Sami", "nour.sami@example.com", (short) 15, "0100000006", LocalDate.of(2025, 7, 18), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Youssef", "Tamer", "youssef.tamer@example.com", (short) 15, "0100000007", LocalDate.of(2025, 2, 22), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Mona", "Fahmy", "mona.fahmy@example.com", (short) 15, "0100000008", LocalDate.of(2025, 4, 10), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Khaled", "Mostafa", "khaled.mostafa@example.com", (short) 15, "0100000009", LocalDate.of(2025, 9, 1), "Junior", UUID.randomUUID()),
//                    new Employee(UUID.randomUUID(), "Huda", "Samir", "huda.samir@example.com", (short) 15, "0100000010", LocalDate.of(2025, 11, 12), "Junior", UUID.randomUUID())
//            ));

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee findOne(UUID employeeId) {
//        return emps.stream().filter(emp -> emp.getId().equals(employeeId))
//                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
    }

    @Override
    public List<Employee> findAll() {
//        return emps;
        return employeeRepo.findAll();
    }

    @Override
    public void deleteOne(UUID employeeId) {
//        Employee employee = emps.stream().filter(emp -> emp.getId().equals(employeeId))
//                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
//        emps.remove(employee);
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public Employee updateOne(UUID employeeId, EmployeeUpdateDTO reqEmp) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (reqEmp.firstName() != null) {
            employee.setFirstName(reqEmp.firstName());
        }
        if (reqEmp.lastName() != null) {
            employee.setLastName(reqEmp.lastName());
        }
        if (reqEmp.position() != null) {
            employee.setPosition(reqEmp.position());
        }
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public Employee create(EmployeeCreateDTO emp) {
        Employee employee = new Employee(emp);
        Department dep = departmentRepo.findById(emp.department()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found"));
//        emps.add(employee);
        employee.setDepartmentId(dep);
        employeeRepo.save(employee);
        return employee;
    }

}
