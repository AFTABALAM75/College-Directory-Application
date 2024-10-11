package com.example.collegedirectory.repository;

import com.example.collegedirectory.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Find courses by department
    List<Course> findByDepartmentId(Long departmentId);
    
    // Find courses taught by a specific faculty member
    List<Course> findByFacultyId(Long facultyId);
}
