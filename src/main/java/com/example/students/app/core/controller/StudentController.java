package com.example.students.app.core.controller;

import com.example.students.app.core.model.GradeSubject;
import com.example.students.app.core.model.Student;
import com.example.students.app.core.module.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
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

        return "redirect:/grade/add?studentId=" + student.getId();

    }

    @GetMapping("/list")
    public String findAllStudents(Model model) {
        List<Student> studentList = studentService.findAllStudents();
        model.addAttribute("whiteSpace", "\n<br>");
        model.addAttribute("studentList", studentList);

        return "student_list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "studentId") Long studentId) {
        studentService.delete(studentId);
        return "redirect:/student/list";
    }

    @GetMapping("/grades/{id}")
    public String grades(@PathVariable(name = "id") Long studentId, Model model) {

        Optional<Student> studentOptional = studentService.findStudent(studentId);

        if (studentOptional.isPresent()) {
            Student foundStudent = studentOptional.get();
            model.addAttribute("student", foundStudent);
            model.addAttribute("gradeSubjects", GradeSubject.values());

            DecimalFormat df = new DecimalFormat("#.##");
            model.addAttribute("average", df.format(foundStudent.getAverage()));

            return "student_grades";
        }

        return "student_list";
    }


}