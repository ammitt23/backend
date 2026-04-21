package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.Admin;
import com.skillgappro.backend.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")

public class AdminController {

    private final AdminService service;

    // 🔥 SECRET CODE
    private static final String ADMIN_SECRET = "SGP_ADMIN_2026";

    public AdminController(AdminService service) {
        this.service = service;
    }

    // ✅ GET ALL
    @GetMapping
    public List<Admin> getAll() {
        return service.getAll();
    }

    // ✅ CREATE ADMIN (FINAL FIX)
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Admin admin) {
        try {
            System.out.println("👉 Incoming Admin: " + admin.getEmail());

            // 🔥 VALIDATE SECRET CODE
            if (admin.getAdminCode() == null || !ADMIN_SECRET.equals(admin.getAdminCode())) {
                return ResponseEntity.badRequest().body("Invalid admin secret code");
            }

            // 🔥 VALIDATION
            if (admin.getEmail() == null || admin.getEmail().isEmpty()) {
                return ResponseEntity.badRequest().body("Email is required");
            }

            if (service.existsByEmail(admin.getEmail())) {
                return ResponseEntity.badRequest().body("Email already exists");
            }

            // 🔥 SET ROLE
            admin.setRole("ADMIN");

            // 🔥 SAVE
            Admin saved = service.save(admin);

            System.out.println("✅ Saved Admin ID: " + saved.getId());

            // 🔥 RETURN STRING (FIXES "1" ISSUE)
            return ResponseEntity.ok(
                    "Admin created successfully with ID: " + saved.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}