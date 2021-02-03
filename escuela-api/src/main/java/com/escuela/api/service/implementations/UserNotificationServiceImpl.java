package com.escuela.api.service.implementations;

import com.escuela.api.constants.EmailTemplateNames;
import com.escuela.api.db.models.Contact;
import com.escuela.api.db.models.User;
import com.escuela.api.service.interfaces.UserEmailNotificationService;
import com.escuela.api.service.interfaces.EmailService;
import com.escuela.api.ui.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserNotificationServiceImpl implements UserEmailNotificationService {

    @Autowired
    EmailService emailService;

    /**
     * @param user
     */
    public void recruiterEmailVerificationNotice(User user){
        Mail mail=new Mail();
        mail.setTemplateName(EmailTemplateNames.RECRUITER_EMAIL_VERIFICATION_TEMPLATE);
        emailService.sendEmails(getMailDetails(user));
    }

    private Mail getMailDetails(User user) {
        Mail mail = new Mail();
        mail.setEmail(user.getEmail());
        //mail.setMessage(newContact.getMessage());
        mail.setSubject("[Esquela-Tech] Company Verification Needed ");
        mail.setFrom("ESQUELA-TECH");
        mail.setAck("Thanks for registering with Esquela-tech, " +
                "Please click on the below link to complete the registration process");
        mail.setTemplateName("/email_templates/contactus_mail.ftl");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("message", mail);
        model.put("greeting", "Hello " + user.getLastName() + " " + user.getFirstName() + ",");
        model.put("baseUrl", "www.esquela-tech.com"); //not used
        mail.setTemplateModel(model);
        return mail;
    }
}
