package com.example.appointment.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    public final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> allContactUs(){
        return contactRepository.findAll();
    }

    public String addContact(Contact contact){
        contactRepository.save(contact);
        return "Thank you for your message";
    }

    public void removeContact(Long id){
        contactRepository.deleteById(id);
    }

}
