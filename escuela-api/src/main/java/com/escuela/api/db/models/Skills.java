package com.escuela.api.db.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="skill_id")
    int skillId;

    @Column(name="skill_name")
    String skillName;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SkillMapping> skillMappings;


    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public List<SkillMapping> getSkillMappings() {
        return skillMappings;
    }

    public void setSkillMappings(List<SkillMapping> skillMappings) {
        this.skillMappings = skillMappings;
    }
}
