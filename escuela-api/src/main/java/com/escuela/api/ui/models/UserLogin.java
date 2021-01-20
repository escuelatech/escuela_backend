package com.escuela.api.ui.models;

public class UserLogin {

    String firstName;
    String lastName;
    String loginSocialMedium;
    String email;
    String profileStatus;

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

    public String getLoginSocialMedium() {
        return loginSocialMedium;
    }

    public void setLoginSocialMedium(String loginSocialMedium) {
        this.loginSocialMedium = loginSocialMedium;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(String profileStatus) {
        this.profileStatus = profileStatus;
    }
}
