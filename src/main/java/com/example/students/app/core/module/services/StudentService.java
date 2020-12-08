package com.example.students.app.core.module.services;

import com.example.students.app.core.model.Student;
import com.example.students.app.core.module.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save (Student student) {
        studentRepository.save(student);
    }
}
