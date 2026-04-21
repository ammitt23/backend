package com.skillgappro.backend.service;

import com.skillgappro.backend.entity.Admin;
import com.skillgappro.backend.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository repo;

    public AdminService(AdminRepository repo) {
        this.repo = repo;
    }

    // ✅ FIX: ADD THIS METHOD
    public List<Admin> getAll() {
        return repo.findAll();
    }

    // ✅ EXISTING METHODS
    public Optional<Admin> getByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Admin save(Admin admin) {
        return repo.save(admin);
    }

    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }
}