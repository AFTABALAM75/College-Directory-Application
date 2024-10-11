// UserRepository.java
package com.example.collegedirectory.repository;

import com.example.collegedirectory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
