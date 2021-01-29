package com.escuela.api.service.implementations;

import com.escuela.api.constants.EmailTemplateNames;
import com.escuela.api.db.models.User;
import com.escuela.api.service.interfaces.UserEmailNotificationService;
import com.escuela.api.service.interfaces.EmailService;
import com.escuela.api.ui.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        emailService.sendEmails(mail);
    }

}
