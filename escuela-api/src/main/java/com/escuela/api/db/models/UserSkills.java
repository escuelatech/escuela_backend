package com.escuela.api.db.models;

import javax.persistence.*;

@Entity
@Table(name = "user_tech_skills")
public class UserSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private String id;

    @Column(name ="skill_name")
    private String skillName;

    @Column(name ="skill_id")
    private String skillId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }
}
