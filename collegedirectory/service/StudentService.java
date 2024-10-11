// StudentService.java
package com.example.collegedirectory.service;

import com.example.collegedirectory.entity.StudentProfile;
import com.example.collegedirectory.entity.User;
import com.example.collegedirectory.repository.StudentProfileRepository;
import com.example.collegedirectory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private UserRepository userRepository;

    public StudentProfile getProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return studentProfileRepository.findByUser(user);
        }
        return null;
    }

    // Other methods: search students, contact faculty
}
