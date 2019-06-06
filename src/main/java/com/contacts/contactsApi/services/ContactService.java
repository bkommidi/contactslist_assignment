package com.contacts.contactsApi.services;

import com.contacts.contactsApi.repositories.ContactRepository;
import com.contacts.contactsApi.models.Contact;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class ContactService {
    private static ContactService instance;

    @Autowired
    private ContactRepository contactRepository;

    private ContactService() {

    }

    public List<Contact> getAllContacts() throws NullPointerException {
        List<Contact> contacts = new ArrayList<Contact>();
        Iterable<Contact> contact = contactRepository.findAll();
        
        contact.forEach(contacts::add);

        return contacts;
    }

    public Contact getContact(String id) {
        return contactRepository.findById(id).orElse(null);
    }

    public void updateContact(Contact contact) {
        if (contactRepository.findById(contact.getId()).isPresent()) {
            saveContact(contact);
        } else {
            throw new IllegalArgumentException("Couldn't save contact because it doesn't exist.");
        }
    }

    public void deleteContact(String id) {
        if (contactRepository.findById(id).isPresent()) {
            contactRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Couldn't delete contact because it doesn't exist.");
        }
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }
}