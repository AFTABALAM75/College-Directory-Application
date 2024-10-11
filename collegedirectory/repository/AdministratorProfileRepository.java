package com.example.collegedirectory.repository;

import com.example.collegedirectory.model.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorProfileRepository extends JpaRepository<AdministratorProfile, Long> {
    // Custom queries if needed
}
