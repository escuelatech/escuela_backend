package com.escuela.api.db.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    int userId;

    @Column(name="user_file")
    byte[] userFile;

    @Column(name="user_profile_pic")
    byte[] userProfilePic;

    @Column(name="linkedIn_link")
    String linkedinLink;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id_fk", referencedColumnName = "user_id")
    public List<Skills> skills;

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public byte[] getUserFile() {
        return userFile;
    }

    public void setUserFile(byte[] userFile) {
        this.userFile = userFile;
    }

    public byte[] getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(byte[] userProfilePic) {
        this.userProfilePic = userProfilePic;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }
}
