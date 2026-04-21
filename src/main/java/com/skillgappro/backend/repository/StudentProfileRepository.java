package com.skillgappro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillgappro.backend.entity.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}