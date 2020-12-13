package com.example.students.app.core.module.services;

import com.example.students.app.core.model.Student;
import com.example.students.app.core.module.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public void delete (Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> findStudent(Long studentId) {
        return studentRepository.findById(studentId);
    }



}
