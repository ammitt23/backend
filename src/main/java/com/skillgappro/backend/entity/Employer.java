package com.skillgappro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "emplyers")

public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clerkId;
    private String contactName;
    private String email;
    private String phone;

    private String companyName;
    private String companyWebsite;
    private String companySize;
    private String industry;

    private Boolean isVerified;
    private LocalDateTime createdAt;
}