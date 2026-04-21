package com.skillgappro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private String category;
    private String resourceUrl;
    private String level;

    private Integer estimatedHours;
}
