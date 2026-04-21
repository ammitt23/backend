package com.skillgappro.backend.repository;

import com.skillgappro.backend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    // ✅ FIXED METHODS
    Optional<Admin> findByEmail(String email);

    boolean existsByEmail(String email);
}