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
    public void sendEmails(Mail mValue){
         Mail mail = new Mail();
            mail.setEmail(mValue.getEmail());
            mail.setMessage(mValue.getMessage());
            mail.setSubject("[Esquela-Tech] Customer Enquiry Received ");
            mail.setFrom("ESQUELA-TECH");
            mail.setAck("Thanks for your enquiry, " +
            "We are happy to help you. Our team will be in touch with you soon.");
            Map<String, Object> model = new HashMap<String,Object>();
            model.put("message",mail);
            model.put("greeting", "Hello "+mValue.getLastName() +" "+mValue.getFirstName()+",");
            model.put("baseUrl", "www.esquela-tech.com"); //not used
            try {
                email.sendInDividualEmail(mail.getEmail(), mail.getSubject(),
                        templateService.getData(model, "/contactus_mail.ftl"));
                System.err.println(String.format("Contact Email sent from: %s", mail.getFrom()));
            } catch (Exception e) {
                e.printStackTrace(); //todo hANDLE eXCEPTION
            }
    }


}
