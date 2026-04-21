//package com.skillgappro.backend.entity;
//
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//
//@Data
//
//@Entity
//@Table(name = "skillscores")
//public class SkillScore {
//
//    private String skillName;
//    private Integer studentScore;
//    private Integer industryRequired;
//    private Integer gapValue;
//    private String priority;
//}

package com.skillgappro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "skill_scores")  // better naming
public class SkillScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // 🔥 REQUIRED

    private String skillName;
    private Integer studentScore;
    private Integer industryRequired;
    private Integer gapValue;
    private String priority;
}