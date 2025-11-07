package com.example.studentManagement.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Course is required")
    private String course;

    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;
}
