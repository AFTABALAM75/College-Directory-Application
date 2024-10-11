package com.example.collegedirectory.repository;

import com.example.collegedirectory.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    // Custom queries, for example, finding students by department
    List<StudentProfile> findByDepartmentId(Long departmentId);
}
