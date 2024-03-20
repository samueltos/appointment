package com.example.appointment.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Contact>> contactUs(){
        List<Contact> contacts = contactService.allContactUs();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> contactUs(@RequestBody Contact contact){
        String message = contactService.addContact(contact);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> contact(@PathVariable Long id){
        contactService.removeContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
