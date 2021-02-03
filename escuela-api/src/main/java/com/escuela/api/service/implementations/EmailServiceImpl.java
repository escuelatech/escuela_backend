package com.escuela.api.service.implementations;


import com.escuela.api.service.interfaces.EmailService;
import com.escuela.api.service.interfaces.TemplateService;
import com.escuela.api.ui.models.Mail;
import com.escuela.api.utilities.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailUtils email;

    @Autowired
    TemplateService templateService;

    @Async
    public void sendEmail(Mail mail){
        mail.setMessage(templateService.getData(mail.getTemplateModel(),mail.getTemplateName()));
        email.sendInDividualEmail(mail.getMessage(),mail.getTo(),mail.getSubject());
    }


    @Deprecated
    @Async
    public void sendEmails(Mail mValue){
         try {
                email.sendInDividualEmail(mValue.getEmail(), mValue.getSubject(),
                        templateService.getData(mValue.getTemplateModel(), mValue.getTemplateName()));
                System.err.println(String.format("Mail sent with Sub: %s, From:%s", mValue.getSubject(),mValue.getFrom()));
         } catch (Exception e) {
                e.printStackTrace(); //todo hANDLE eXCEPTION
         }
    }

}
