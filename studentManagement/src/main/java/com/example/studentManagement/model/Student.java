package com.example.studentManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Course cannot be blank")
    private String course;

    @Min(value = 18, message = "Age must be greater than 18")
    private int age;

    public Student() {}

    public Student(Integer id, String name, String email, String course, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
