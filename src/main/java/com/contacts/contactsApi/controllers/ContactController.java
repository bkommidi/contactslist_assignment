package com.contacts.contactsApi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.contactsApi.models.Contact;
import com.contacts.contactsApi.services.*;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;
    private String id;

    @GetMapping("/contacts/{id}")
    Contact getContact(@PathVariable("id") String id) {
        return contactService.getContact(id);
    }

    @GetMapping("/contacts")
    List<Contact> getContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping("/contacts")
    ResponseEntity<Object> addContact(@RequestBody Contact contact) {
        try {
            contactService.saveContact(contact);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/contacts")
    ResponseEntity<Object> updateContact(@RequestBody Contact contact) {
        try {
            contactService.updateContact(contact);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/contacts/{id}")
    ResponseEntity<Object> deleteContact(@PathVariable("id") String id) {
        try {
            contactService.deleteContact(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}