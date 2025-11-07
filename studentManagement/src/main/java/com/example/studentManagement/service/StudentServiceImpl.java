package com.example.studentManagement.service;




import com.example.studentManagement.dto.StudentDTO;
import com.example.studentManagement.model.Student;
import com.example.studentManagement.repo.StudentRepo;
import com.example.studentManagement.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    private StudentDTO mapToDTO(Student s) {
        return modelMapper.map(s, StudentDTO.class);
    }

    private Student mapToEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student saved = studentRepo.save(mapToEntity(studentDTO));
        return mapToDTO(saved);
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        Student s = studentRepo.findById(id)
                .orElseThrow();
        return mapToDTO(s);
    }

    @Override
    public Page<StudentDTO> getAllStudents(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Student> studentsPage = studentRepo.findAll(pageable);
        List<StudentDTO> dtos = studentsPage.getContent().stream().map(this::mapToDTO).collect(Collectors.toList());
        return new PageImpl<>(dtos, pageable, studentsPage.getTotalElements());
    }

    @Override
    public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
        Student existing = studentRepo.findById(id)
                .orElseThrow();
        // update fields
        existing.setName(studentDTO.getName());
        existing.setEmail(studentDTO.getEmail());
        existing.setCourse(studentDTO.getCourse());
        existing.setAge(studentDTO.getAge());
        Student updated = studentRepo.save(existing);
        return mapToDTO(updated);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student s = studentRepo.findById(id)
                .orElseThrow();
        studentRepo.delete(s);
    }

    @Override
    public List<StudentDTO> searchByName(String name) {
        return studentRepo.findByNameContainingIgnoreCase(name).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> searchByCourse(String course) {
        return studentRepo.findByCourseContainingIgnoreCase(course).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}

