package com.skillgappro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "benchmarks")
public class Benchmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Skill or Technology name (Java, React, etc.)
    private String skillName;

    // Required level for industry (1–10)
    private int requiredLevel;

    // Job role (SDE, Frontend Dev, etc.)
    private String jobRole;

    // Optional description
    private String description;
}