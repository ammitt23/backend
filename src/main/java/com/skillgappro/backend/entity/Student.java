package com.skillgappro.backend.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")   // ✅ FIXED
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String clerkId;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    // ❌ REMOVED password (Clerk handles auth)

    private String phone;
    private String city;

    private String collegeName;
    private String branch;
    private Integer semester;
    private Double cgpa;
    private Integer graduationYear;

    private String targetRole;
    private Boolean openToWork;
    private String preferredJobType;

    private Boolean isProfilePublic;
    private String resumeUrl;
    private String githubUrl;

    private Boolean isPro = false;
    private Integer streakCount = 0;

    // ✅ IMPORTANT for auth system
    @Column(nullable = false)
    private String role = "STUDENT";

    // ✅ Auto timestamp
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}