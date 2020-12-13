package com.example.students.app.core.module.repositories;

import com.example.students.app.core.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepostiory extends JpaRepository<Grade, Long> {
}
