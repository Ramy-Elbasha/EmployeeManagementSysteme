package com.Ecommerce.Ecommerce_Management_System.DTOs;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    @NotNull(message = "first name can't be null")
    private String firstName;
    private String lastName;
    @Min(10)
    @Max(30)
    private short age;
    @Email
    private String Email;
    @Size(min = 5, max = 12)
    private String position;
    private String Phone;
}
