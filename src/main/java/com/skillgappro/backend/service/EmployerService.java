package com.skillgappro.backend.service;

import com.skillgappro.backend.entity.Employer;
import com.skillgappro.backend.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployerService {

    private final EmployerRepository repo;

    public EmployerService(EmployerRepository repo) {
        this.repo = repo;
    }

    public Optional<Employer> getByEmail(String email) {
        return repo.findByEmail(email);
    }
}