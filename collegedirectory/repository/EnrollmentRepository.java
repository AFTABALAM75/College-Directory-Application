package com.example.collegedirectory.repository;

import com.example.collegedirectory.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Custom queries for fetching enrollments by student or course
    List<Enrollment> findByStudentId(Long studentId);
    
    List<Enrollment> findByCourseId(Long courseId);
}
