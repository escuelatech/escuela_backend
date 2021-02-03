package com.escuela.api.service.implementations;

import com.escuela.api.db.models.*;
import com.escuela.api.jpa.repositories.*;
import com.escuela.api.service.interfaces.EmailService;
import com.escuela.api.service.interfaces.RecruiterService;
import com.escuela.api.service.interfaces.UserService;
import com.escuela.api.ui.models.Mail;
import com.escuela.api.ui.models.RecruiterWrapper;
import com.escuela.api.ui.models.UserLogin;
import com.escuela.api.ui.models.UserWrapper;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

@Service(value = "recruiterservice")
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    RecruiterRepository recruiterRepository;

    @Autowired
    EmailService emailService;

    @Override
    public List<Recruiter> getAllRegisteredRecruiters() {
        return null;
    }

    @Override
    public String createRecruiterProfile(Recruiter recruiter) {
        String message = null;
        Optional<Recruiter> dbRecruiter=recruiterRepository.findUserByEmailID(recruiter.getEmail());
        if(dbRecruiter.isPresent()) {
            Recruiter recruiterDb = dbRecruiter.get();
            message = recruiterDb.getEmail()+ "is already register with us";
        }else {
            //Recruiter recruiter=re.getRecruiter();
            recruiter.setStatus("pending");
            recruiter.setVerificationCode(RandomString.make(64));
            if (recruiterRepository.save(recruiter) != null) {
                emailService.sendEmails(getMailDetails(recruiter));
            }
            message = "Recruiter Profile Created, Verification Code is send to "+recruiter.getEmail();
        }
        return message;

    }


    private Mail getMailDetails(Recruiter recruiter) {
        Mail mail = new Mail();
        mail.setEmail(recruiter.getEmail());
        mail.setMessage("Account Activation for Recruiter Name :"+recruiter.getName());
        mail.setSubject("[Esquela-Tech] Account Activation");
        mail.setFrom("ESQUELA-TECH");
        mail.setAck("Thanks for registering with us, " +
                "<a href='http://localhost:9093/recruiter/verifyrecruiter?id="+recruiter.getId()+"&"+
                "verify="+recruiter.getVerificationCode()+"'>" +
                "Please click here </a>" +
                "For activating your account");
        mail.setTemplateName("/email_templates/contactus_mail.ftl");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("message", mail);
        model.put("greeting", "Hello " +recruiter.getName()+ ",");
        model.put("baseUrl", "www.esquela-tech.com"); //not used
        mail.setTemplateModel(model);
        return mail;
    }

}
