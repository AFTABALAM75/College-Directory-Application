package com.example.collegedirectory.repository;

import com.example.collegedirectory.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // You can add custom query methods if needed
}
