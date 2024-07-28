package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/")
    public Contact sendMessage(@RequestBody Contact contact) {
        return contactService.sendMessage(contact);
    }

    @GetMapping("/admin")
    public List<Contact> showAllMessages() {
        return contactService.showAllMessages();
    }

    @GetMapping("/user/{id}")
    public List<Contact> showMessageUser(@PathVariable Integer id) {
        return contactService.showMessageUser(id);
    }
}
