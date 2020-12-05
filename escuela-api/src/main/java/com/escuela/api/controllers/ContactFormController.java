package com.escuela.api.controllers;


import com.escuela.api.db.models.Contact;
import com.escuela.api.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contact")
public class ContactFormController {

    final
    ContactService contactService;

    public ContactFormController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/submitform")
    public String contactUs(@RequestBody Contact newContact){
        return contactService.contactUs(newContact);
    }
}
