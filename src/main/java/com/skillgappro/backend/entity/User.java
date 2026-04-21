package com.skillgappro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data   // 🔥 THIS FIXES EVERYTHING
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clerkId;
    private String email;

    private String role;
    private boolean isPro;

    private boolean profileCompleted = false;
    public boolean isPro() { return isPro; }
    public void setIsPro(boolean isPro) { this.isPro = isPro; }
}