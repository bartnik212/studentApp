package com.example.students.app.core.controller;

import com.example.students.app.core.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("landing_page")
    public String getLandingPage(Model model) {
        model.addAttribute("helloSentence", "Witam w E-dzienniku");
        return "landing_page";
    }

//    @GetMapping("/add")
//    public String addStudent(Model model) {
//        model.addAttribute("newStudent", new Student());
//
//        return "student_form";
//    }
//
//    @PostMapping("/add")
//    public String postStudent() {
//
//        return "student_form";
//    }
}
