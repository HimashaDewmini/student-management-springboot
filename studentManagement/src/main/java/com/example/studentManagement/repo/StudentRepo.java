package com.example.studentManagement.repo;

import com.example.studentManagement.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByCourseContainingIgnoreCase(String course);

    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Student> findByCourseContainingIgnoreCase(String course, Pageable pageable);
}
