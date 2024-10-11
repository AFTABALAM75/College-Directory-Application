package com.example.collegedirectory.repository;

import com.example.collegedirectory.model.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {
    // Custom queries, e.g., find faculty members by department
    List<FacultyProfile> findByDepartmentId(Long departmentId);
}
