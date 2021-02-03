package com.escuela.api.service.implementations;

import com.escuela.api.db.models.CourseTraining;
import com.escuela.api.db.models.Recruiter;
import com.escuela.api.jpa.repositories.CourseTrainingRepository;
import com.escuela.api.service.interfaces.CourseTrainingService;
import com.escuela.api.service.interfaces.EmailService;
import com.escuela.api.ui.models.Mail;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service(value = "coursetrainingservice")
public class CourseTrainingServiceImpl implements CourseTrainingService {

    @Autowired
    CourseTrainingRepository courseTrainingRepository;

    @Autowired
    EmailService emailService;

    @Override
    public List<CourseTraining> getAllUserTrainees() {
        return null;
    }

    @Override
    public String createUserTraineeProfile(CourseTraining training) {
        String message = null;
        Optional<CourseTraining> dbCourseTraining = courseTrainingRepository.findUserByEmailID(training.getEmail());
        if(dbCourseTraining.isPresent()){
            CourseTraining courseTrainingDb = dbCourseTraining.get();
            message = courseTrainingDb.getEmail() + " is already registered with us. Please check your email for further instructions.";
        } else {
            training.setStatus("pending");
            training.setVerificationCode(RandomString.make(64));
            if(courseTrainingRepository.save(training) != null){
                emailService.sendEmails(getMailDetails(training));
            }
            message = "Your Profile has been created. Verification Code is send to " + training.getEmail();
        }
       return message;
    }

    private Mail getMailDetails(CourseTraining trainee) {
        Mail mail = new Mail();
        mail.setEmail(trainee.getEmail());
        mail.setMessage("Account Activation for Trainee :"+trainee.getFirstName());
        mail.setSubject("[Escuela-Tech] Account Activation");
        mail.setFrom("ESCUELA-TECH");
        mail.setAck("Thanks for registering with us, " +
                "<a href='https://us04web.zoom.us/j/79754491913?pwd=Z1cxUGtKUVRoYzlNUWZkdVNoWWR6dz09#success'>Click this zoom link for meeting</a>" +
                "The meeting will be held on Feb 6, 2021 at 10:00am");
        mail.setTemplateName("/email_templates/trainee_email_verification.ftl");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("message", mail);
        model.put("greeting", "Hello " +trainee.getFirstName()+ ",");
        model.put("baseUrl", "www.escuelatech.com"); //not used
        mail.setTemplateModel(model);
        return mail;
    }
}
