package com.Ecommerce.Ecommerce_Management_System.services;

import com.Ecommerce.Ecommerce_Management_System.DTOs.EmployeeDTO;
import com.Ecommerce.Ecommerce_Management_System.abstracts.EmployeeSerivce;
import com.Ecommerce.Ecommerce_Management_System.entities.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImp implements EmployeeSerivce {

    List<Employee> emps = new ArrayList<Employee>(
            List.of(
                    new Employee(UUID.randomUUID(), "Ramy", "Elbasha", "ramy.elbasha@example.com", (short) 15, "0100000001", LocalDate.of(2025, 8, 12), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Ahmed", "Hassan", "ahmed.hassan@example.com", (short) 15, "0100000002", LocalDate.of(2025, 5, 20), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Sara", "Mahmoud", "sara.mahmoud@example.com", (short) 15, "0100000003", LocalDate.of(2025, 3, 15), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Laila", "Khaled", "laila.khaled@example.com", (short) 15, "0100000004", LocalDate.of(2025, 1, 30), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Omar", "Ali", "omar.ali@example.com", (short) 15, "0100000005", LocalDate.of(2025, 6, 5), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Nour", "Sami", "nour.sami@example.com", (short) 15, "0100000006", LocalDate.of(2025, 7, 18), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Youssef", "Tamer", "youssef.tamer@example.com", (short) 15, "0100000007", LocalDate.of(2025, 2, 22), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Mona", "Fahmy", "mona.fahmy@example.com", (short) 15, "0100000008", LocalDate.of(2025, 4, 10), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Khaled", "Mostafa", "khaled.mostafa@example.com", (short) 15, "0100000009", LocalDate.of(2025, 9, 1), "Junior", UUID.randomUUID()),
                    new Employee(UUID.randomUUID(), "Huda", "Samir", "huda.samir@example.com", (short) 15, "0100000010", LocalDate.of(2025, 11, 12), "Junior", UUID.randomUUID())
            ));

    @Override
    public Employee findOne(UUID employeeId) {

        return emps.stream().filter(emp -> emp.getId().equals(employeeId))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    @Override
    public List<Employee> findAll() {
        return emps;
    }

    @Override
    public void deleteOne(UUID employeeId) {
        Employee employee = emps.stream().filter(emp -> emp.getId().equals(employeeId))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
        emps.remove(employee);
    }

    @Override
    public Employee updateOne(UUID employeeId, Employee reqEmp) {
        Employee employee = emps.stream().filter(emp -> emp.getId().equals(employeeId))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
        if (reqEmp.getFirstName() != null) {
            employee.setFirstName(reqEmp.getFirstName());
        }
        if (reqEmp.getLastName() != null) {
            employee.setLastName(reqEmp.getLastName());
        }
        if (reqEmp.getPosition() != null) {
            employee.setPosition(reqEmp.getPosition());
        }
        if (reqEmp.getHireDate() != null) {
            employee.setHireDate(reqEmp.getHireDate());
        }
        if (reqEmp.getEmail() != null) {
            employee.setEmail(reqEmp.getEmail());
        }
        return employee;
    }

    @Override
    public Employee create(EmployeeDTO emp) {
        Employee employee = new Employee(emp);
        emps.add(employee);
        return employee;
    }

}
