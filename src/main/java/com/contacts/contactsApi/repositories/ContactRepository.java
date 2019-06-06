package com.contacts.contactsApi.repositories;

import com.contacts.contactsApi.models.Contact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {

}