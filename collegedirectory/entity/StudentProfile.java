// StudentProfile.java
package com.example.collegedirectory.entity;

import javax.persistence.*;

@Entity
public class StudentProfile {
    @Id
    private Long id; // Same as User ID

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String year;

    // Constructors, Getters, Setters
}
