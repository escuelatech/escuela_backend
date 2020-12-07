package com.escuela.api.db.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="skill_mapping")
public class SkillMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="skill_id")
    int skillId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    int userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_fid", nullable = false)
    private Registration user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_fid", nullable = false)
    private List<Skills> skills;


    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Registration getUser() {
        return user;
    }

    public void setUser(Registration user) {
        this.user = user;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }
}

