package com.Ecommerce.Ecommerce_Management_System.DTOs;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record EmployeeCreateDTO(
        @NotNull(message = "first name can't be null")
        String firstName,
        String lastName,
        @Min(10)
        @Max(30)
        short age,
        @Email
        String email,
        @Size(min = 5, max = 12)
        String position,
        String phoneNumber,
        @NotNull(message = "Department can't be null")
        UUID department
) {
}
