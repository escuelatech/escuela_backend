package com.escuela.api.db.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="user_id")
    private Integer userId;

    @Column(name = "email_id")
    private String email;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "registration")
    private List<UserSkillMapping> skills;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<UserSkillMapping> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkillMapping> skills) {
        this.skills = skills;
    }
}
