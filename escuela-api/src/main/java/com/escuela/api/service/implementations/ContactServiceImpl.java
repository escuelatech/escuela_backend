package com.escuela.api.service.implementations;


import com.escuela.api.db.models.Contact;
import com.escuela.api.jpa.repositories.ContactRepository;
import com.escuela.api.service.interfaces.ContactService;
import com.escuela.api.service.interfaces.EmailService;
import com.escuela.api.ui.models.Mail;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "contactservice")
public class ContactServiceImpl implements ContactService {
    final
    ContactRepository contactRepository;

    final
    EmailService emailService;

    public ContactServiceImpl(ContactRepository contactRepository,EmailService emailService) {
        this.contactRepository = contactRepository;
        this.emailService = emailService;
    }

    public  String contactUs(Contact newContact){
        emailService.sendEmails(getMailDetails(newContact));
        contactRepository.save(newContact);
        return "successfully submitted your contact";
    }

    private Mail getMailDetails(Contact newContact) {
        Mail mail = new Mail();
        mail.setEmail(newContact.getEmail());
        mail.setMessage(newContact.getMessage());
        mail.setSubject("[Esquela-Tech] Customer Enquiry Received ");
        mail.setFrom("ESQUELA-TECH");
        mail.setAck("Thanks for your enquiry, " +
                "We are happy to help you. Our team will be in touch with you soon.");
        mail.setTemplateName("/email_templates/contactus_mail.ftl");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("message", mail);
        model.put("greeting", "Hello " + newContact.getLastName() + " " + newContact.getFirstName() + ",");
        model.put("baseUrl", "www.esquela-tech.com"); //not used
        mail.setTemplateModel(model);
        return mail;
    }
}
