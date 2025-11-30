package com.Ecommerce.Ecommerce_Management_System.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record EmployeeUpdateDTO(
        String firstName,
        String lastName,
        @Min(10)
        @Max(30)
        Short age,
        @Size(min = 5, max = 12)
        String position,
        String phone) {
}
