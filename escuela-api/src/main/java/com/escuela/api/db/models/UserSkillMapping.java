package com.escuela.api.db.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "user_skill_mapping")
public class UserSkillMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="map_id")
    private Integer mapId;

    @Column(name ="skill_id")
    String skillId;

    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Registration registration;

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }
}
