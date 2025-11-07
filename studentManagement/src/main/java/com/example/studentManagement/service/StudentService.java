package com.example.studentManagement.service;



import com.example.studentManagement.dto.StudentDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Integer id);
    Page<StudentDTO> getAllStudents(int page, int size, String sortBy, String sortDir);
    StudentDTO updateStudent(Integer id, StudentDTO studentDTO);
    void deleteStudent(Integer id);
    List<StudentDTO> searchByName(String name);
    List<StudentDTO> searchByCourse(String course);
}
