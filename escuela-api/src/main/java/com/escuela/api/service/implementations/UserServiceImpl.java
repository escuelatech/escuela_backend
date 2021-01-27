package com.escuela.api.service.implementations;

import com.escuela.api.db.models.JobDetails;
import com.escuela.api.db.models.User;
import com.escuela.api.db.models.UserSkillMapping;
import com.escuela.api.db.models.UserSkills;
import com.escuela.api.jpa.repositories.JobDetailsRepository;
import com.escuela.api.jpa.repositories.UserRepository;
import com.escuela.api.jpa.repositories.UserSkillMappingRepository;
import com.escuela.api.jpa.repositories.UserTechSkillsRepository;
import com.escuela.api.service.interfaces.UserService;
import com.escuela.api.ui.models.UserLogin;
import com.escuela.api.ui.models.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "userservice")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSkillMappingRepository userSkillMappingRepository;

    @Autowired
    JobDetailsRepository jobDetailsRepository;

    @Autowired
    UserTechSkillsRepository userTechSkillsRepository;

    public List<User> getAllRegisteredUsers(){
        return userRepository.findAll();
    }

    public User newUser(User newUser){
        return userRepository.save(newUser);
    }

    /**
     *
     * @param resume
     * @param email
     */
    public void saveResume(byte[] resume,String email){
        //User user=userRepository.findUserByEmailID(email);//Read user-by userid/user email
        Optional<User> dbUser=userRepository.findUserByEmailID(email);
        if(dbUser.isPresent()) {
            User user=dbUser.get();
            user.setResume(resume);
            userRepository.save(user);
        }
    }

    @Override
    public Optional<User> findUserByEmailID(String email) {
        return userRepository.findUserByEmailID(email);
    }

//    @Override
    public User findUser(String email) {
        return null;
    }

    @Override
    public String createUserProfile(UserWrapper userWrapper) {

        Optional<User> dbUser=userRepository.findUserByEmailID(userWrapper.getUser().getEmail());

        User user=dbUser.get();
        User userProfileInfo=userWrapper.getUser();

        user.setCity(userProfileInfo.getCity());
        user.setPhone(userProfileInfo.getPhone());
        user.setCollegeLocation(userProfileInfo.getCollegeLocation());
        user.setCollegeName(userProfileInfo.getCollegeName());
        user.setFieldOfStudy(userProfileInfo.getFieldOfStudy());
        user.setHighestDegree(userProfileInfo.getHighestDegree());

        for (UserSkills skill:userWrapper.getSkills()){
            UserSkillMapping skillMapping=new UserSkillMapping();
            skillMapping.setRegistration(user);
            skillMapping.setSkillId(skill.getSkillId());
            userSkillMappingRepository.save(skillMapping);
        }

        for (JobDetails job:userWrapper.getPrevJobs()){
            job.setUserId(user.getUserId());
            jobDetailsRepository.save(job);
        }

        user.setProfileStatus("complete");
        //save the user info.
        newUser(user);
        return "user profile updated";
    }

    @Override
    public UserWrapper fetchUserProfile(String email) {
        //Fetch user from DB
        Optional<User> dbUser=userRepository.findUserByEmailID(email);
        UserWrapper userWrapper=new UserWrapper();
        User user=dbUser.get();
        userWrapper.setUser(user);

        //Fetch user skills from DB
        List<String> skillIds=new ArrayList<String>();
        user.getSkillMapping().forEach(skillId -> skillIds.add(skillId.getSkillId()));
        userWrapper.setSkills(userTechSkillsRepository.findSkillsByIDs(skillIds));

        //Fetch user Jobs
        userWrapper.setPrevJobs(jobDetailsRepository.findUserJobsByID(user.getUserId()));
        return userWrapper;

    }

    /**
     *
     * @param userLogin
     * @return
     */
    public UserLogin userSocialLogin(UserLogin userLogin){
        Optional<User> dbUser=findUserByEmailID(userLogin.getEmail());
        if(!dbUser.isPresent()){
            User user=new User();
            user.setFirstName(userLogin.getFirstName());
            user.setLastName(userLogin.getLastName());
            user.setEmail(userLogin.getEmail());
            user.setProfileStatus("incomplete");
            userLogin.setProfileStatus(user.getProfileStatus());
            newUser(user);
            return userLogin;
        }
        userLogin.setProfileStatus(dbUser.get().getProfileStatus());
        return userLogin;
    }

}
