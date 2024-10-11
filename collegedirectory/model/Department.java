package com.example.collegedirectory.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "department")
    private List<StudentProfile> students;
    
    @OneToMany(mappedBy = "department")
    private List<FacultyProfile> faculty;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentProfile> getStudents() {
        return students;
    }

    public void setStudents(List<StudentProfile> students) {
        this.students = students;
    }

    public List<FacultyProfile> getFaculty() {
        return faculty;
    }

    public void setFaculty(List<FacultyProfile> faculty) {
        this.faculty = faculty;
    }
}
