package com.example.studentManagement.controller;

import com.example.studentManagement.dto.StudentDTO;
import com.example.studentManagement.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Threshold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/students")
@Tag(name = " Student Controller" , description = "Test APIs")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create -> 201
    @PostMapping("/addstudent")
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        StudentDTO created = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get by id -> 200 or 404
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // Get all with pagination and sorting -> 200
    @GetMapping
    public ResponseEntity<Page<StudentDTO>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Page<StudentDTO> students = studentService.getAllStudents(page, size, sortBy, sortDir);
        return ResponseEntity.ok(students);
    }

    // Update -> 200
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentDTO studentDTO) {
        StudentDTO updated = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(updated);
    }

    // Delete -> 200 (or 204)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(Map.of("message", "Student deleted successfully"));
    }

    // Search by name
    @GetMapping("/search/by-name")
    public ResponseEntity<List<StudentDTO>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(studentService.searchByName(name));
    }

    // Search by course
    @GetMapping("/search/by-course")
    public ResponseEntity<List<StudentDTO>> searchByCourse(@RequestParam String course) {
        return ResponseEntity.ok(studentService.searchByCourse(course));
    }
}
