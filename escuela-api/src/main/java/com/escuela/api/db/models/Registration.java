package com.escuela.api.db.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @OneToMany(mappedBy = "registration",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SkillMapping> skillMappings;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SkillMapping> getSkillMappings() {
        return skillMappings;
    }

    public void setSkillMappings(List<SkillMapping> skillMappings) {
        this.skillMappings = skillMappings;
    }
}
