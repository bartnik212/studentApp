package com.example.students.app.core.module.services;

import com.example.students.app.core.model.Grade;
import com.example.students.app.core.module.repositories.GradeRepostiory;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    private final GradeRepostiory gradeRepostiory;

    public GradeService(GradeRepostiory gradeRepostiory) {
        this.gradeRepostiory = gradeRepostiory;
    }

    public void update(Grade grade) {
        gradeRepostiory.save(grade);
    }

    public void delete(Long gradeId) {
        gradeRepostiory.deleteById(gradeId);

    }
}
