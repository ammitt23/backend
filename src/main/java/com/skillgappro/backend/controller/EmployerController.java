package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.Employer;
import com.skillgappro.backend.repository.EmployerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployerController {

    private final EmployerRepository repo;

    public EmployerController(EmployerRepository repo) {
        this.repo = repo;
    }

    // ✅ CREATE EMPLOYER PROFILE
    @PostMapping("/profile")
    public Employer createEmployer(@RequestBody Employer employer) {
        return repo.save(employer);
    }
}