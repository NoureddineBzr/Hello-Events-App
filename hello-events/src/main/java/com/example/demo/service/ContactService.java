package com.example.demo.service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> showAllMessages(){
        return contactRepository.findAll();
    }
    public Contact sendMessage(Contact contact){
        return contactRepository.save(contact);
    }
    public List<Contact> showMessageUser(Integer idUser){
        return contactRepository.findByUser_UserId(idUser);
    }
}
