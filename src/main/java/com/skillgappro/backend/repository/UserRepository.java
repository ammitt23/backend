package com.skillgappro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillgappro.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByClerkId(String clerkId);
}