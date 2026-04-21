package com.skillgappro.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shortlists")
public class Shortlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ ONLY THIS (simple approach)
    @Column(name = "employer_id")
    private Long employerId;

    // other fields
    private Long studentId;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployerId() { return employerId; }
    public void setEmployerId(Long employerId) { this.employerId = employerId; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
}