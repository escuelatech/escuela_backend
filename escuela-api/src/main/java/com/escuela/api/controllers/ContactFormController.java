package com.escuela.api.controllers;


import com.escuela.api.db.models.Contact;
import com.escuela.api.service.interfaces.ContactService;
import com.escuela.api.service.interfaces.EmailService;
import com.escuela.api.ui.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contact")
public class ContactFormController {

    final
    ContactService contactService;

    final
    EmailService emailService;

    public ContactFormController(ContactService contactService,EmailService emailService) {
        this.contactService = contactService;
        this.emailService = emailService;
    }

    @PostMapping("/submitform")
    public String contactUs(@RequestBody Contact newContact){
        emailService.sendEmails(newContact);
        return contactService.contactUs(newContact);
    }
}
