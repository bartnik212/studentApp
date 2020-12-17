package com.example.students.app.core.controller;

import com.example.students.app.core.model.Grade;
import com.example.students.app.core.model.GradeSubject;
import com.example.students.app.core.model.Student;
import com.example.students.app.core.module.services.GradeService;
import com.example.students.app.core.module.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/grade")
public class GradeContoller {

    private final StudentService studentService;
    private final GradeService gradeService;


    public GradeContoller(StudentService studentService, GradeService gradeService) {
        this.studentService = studentService;
        this.gradeService = gradeService;
    }


    @GetMapping("/add")
    public String getGradeForm(Model model, @RequestParam(name = "studentId", required = false) Long studentId) {
        model.addAttribute("grade", new Grade());
        model.addAttribute("studentId", studentId);
        model.addAttribute("allStudents", studentService.findAllStudents());
        model.addAttribute("allSubjects", Arrays.asList(GradeSubject.values()));
        return "grade_form";
    }

    @PostMapping("/add")
    public String submitGrade(Grade grade, Long studentIdValue) {

        Optional<Student> studentOptional = studentService.findStudent(studentIdValue);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            grade.setStudent(student);
            gradeService.update(grade);

            return "redirect:/student/grades/" + studentIdValue;
        } else {
            return "redirect:/student/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "gradeId") Long gradeId) {

        gradeService.delete(gradeId);
        return "redirect:/student/list";
    }
}
