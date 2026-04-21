package com.skillgappro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobposts")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    private String jobType;
    private String stipendOrCTC;

    private Boolean isActive;

    @ManyToOne
    private Employer employer;

    private LocalDateTime createdAt;
}
