package com.Ecommerce.Ecommerce_Management_System.DTOs;

import jakarta.validation.constraints.NotNull;

public record DepartmentCreateDTO(
        @NotNull(message = "mame is required")
        String name
) {
}
