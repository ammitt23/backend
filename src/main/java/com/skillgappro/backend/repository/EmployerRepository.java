package com.skillgappro.backend.repository;

import com.skillgappro.backend.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Optional<Employer> findByEmail(String email);
}