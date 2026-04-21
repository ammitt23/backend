package com.skillgappro.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Which user this notification belongs to
    private Long studentId;

    // 📝 Notification content
    private String title;

    @Column(length = 1000)
    private String message;

    // 📌 Type (JOB, PAYMENT, SYSTEM, etc.)
    private String type;

    // 🔔 Read status
    private Boolean isRead = false;

    // ⏱️ Created time
    private LocalDateTime createdAt = LocalDateTime.now();
}