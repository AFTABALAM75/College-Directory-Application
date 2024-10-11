// User.java
package com.example.collegedirectory.entity;

import javax.persistence.*;

@Entity
@Table(name = "users") // "user" is a reserved keyword in SQL
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // Should be stored hashed

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    // Constructors, Getters, Setters
}
