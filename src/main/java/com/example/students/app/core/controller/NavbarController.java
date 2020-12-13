package com.example.students.app.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/navbar")
public class NavbarController {

    @GetMapping("/")
    public String getNavbar() {
        return "navbar";
    }
}
