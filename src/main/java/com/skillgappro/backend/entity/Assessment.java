package com.skillgappro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data

@Entity
@Table(name = "assessments")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String targetRole;
    private Double overallReadiness;

    @ManyToOne
    private Student student;

    private LocalDateTime createdAt;
}
