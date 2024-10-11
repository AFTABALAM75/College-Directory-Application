// StudentController.java
package com.example.collegedirectory.controller;

import com.example.collegedirectory.entity.StudentProfile;
import com.example.collegedirectory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/profile")
    public StudentProfile getProfile() {
        return studentService.getProfile();
    }

    // Other endpoints: search students, contact faculty
}
