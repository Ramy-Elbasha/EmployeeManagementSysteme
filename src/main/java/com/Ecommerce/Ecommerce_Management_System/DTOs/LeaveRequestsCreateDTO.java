package com.Ecommerce.Ecommerce_Management_System.DTOs;

import com.Ecommerce.Ecommerce_Management_System.entities.Employee;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LeaveRequestsCreateDTO(
        @NotNull
        @FutureOrPresent(message = "Date should be in present or future")
        LocalDate startDate,
        @NotNull
        @FutureOrPresent(message = "Date should be in present or future")
        LocalDate endDate,
        @NotNull
        String reason,
        @NotNull
        String Status,
        @NotNull
        Employee EmployeeId) {
}
