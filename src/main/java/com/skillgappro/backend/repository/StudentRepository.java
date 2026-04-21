package com.skillgappro.backend.repository;

import com.skillgappro.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // 🔥 REQUIRED FOR CLERK SYNC
    Optional<Student> findByClerkId(String clerkId);

    // (optional but useful)
    boolean existsByEmail(String email);
}