package com.escuela.api.service.implementations;


import com.escuela.api.db.models.Contact;
import com.escuela.api.jpa.repositories.ContactRepository;
import com.escuela.api.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "contactservice")
public class ContactServiceImpl implements ContactService {
    final
    ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact contactUs(Contact newContact){
        return contactRepository.save(newContact);
    }
}
