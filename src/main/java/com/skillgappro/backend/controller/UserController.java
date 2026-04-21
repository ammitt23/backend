package com.skillgappro.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.skillgappro.backend.entity.User;
import com.skillgappro.backend.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Create user
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // ✅ Get user by Clerk ID
    @GetMapping("/{clerkId}")
    public ResponseEntity<User> getUser(@PathVariable String clerkId) {
        User user = userRepository.findByClerkId(clerkId);
        if (user == null) {
            return ResponseEntity.notFound().build(); // 404 OK
        }
        return ResponseEntity.ok(user);
    }

    // 🔥 OPTIONAL (BEST): Create or Get (avoid 404)
    @PostMapping("/sync")
    public User syncUser(@RequestBody User reqUser) {
        User existing = userRepository.findByClerkId(reqUser.getClerkId());

        if (existing != null) {
            return existing;
        }

        return userRepository.save(reqUser);
    }

    // ✅ Update profile + role
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔥 SAFE ROLE UPDATE
        if (updatedUser.getRole() != null) {
            user.setRole(updatedUser.getRole());
        }

        user.setProfileCompleted(updatedUser.isProfileCompleted());

        return userRepository.save(user);
    }

    // ✅ Upgrade user
    @PatchMapping("/students/{id}/upgrade")
    public User upgradeUser(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setIsPro(true); // 🔥 IMPORTANT: must match field name in entity

        return userRepository.save(user);


    }
}