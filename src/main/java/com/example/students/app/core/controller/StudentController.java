package com.example.students.app.core.controller;

import com.example.students.app.core.model.Student;
import com.example.students.app.core.module.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("landing_page")
    public String getLandingPage(Model model) {
        model.addAttribute("helloSentence", "Witam w E-dzienniku");
        return "landing_page";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("newStudent", new Student());

        return "student_form";
    }

    @PostMapping("/add")
    public String postStudent(Student student) {
        studentService.save(student);
        return "redirect:/student/landing_page";
    }

    @GetMapping("/list")
    public String findAllStudents(Model model) {
        List<Student> studentList = studentService.findAllStudents();
        model.addAttribute("whiteSpace", "\n<br>");
        model.addAttribute("studentList", studentList);

        return "student_list";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam(name = "studentId") Long studentId) {
        studentService.delete(studentId);
        return "redirect:/student/list";
    }

    @GetMapping("/grades/{id}")
    public String grades(@PathVariable(name = "id") Long studentId, Model model){

        Optional<Student> studentOptional = studentService.findStudent(studentId);
        if (studentOptional.isPresent()) {
            Student foundStudent = studentOptional.get();
            model.addAttribute("student", foundStudent);
            return "student_grades";
        }
        return "student_list";
    }


}