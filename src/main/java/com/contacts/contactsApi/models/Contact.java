package com.contacts.contactsApi.models;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.contacts.contactsApi.models.constants.PhoneType;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Contact {

    @Id
    @GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
    private String id;

    @Embedded
    private Name name;
    
    @Embedded
    private Address address;

    @ElementCollection
    private List<Phone> phone;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    public Contact() {
        // Default constructor
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public List<Phone> getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    @JsonProperty("name")
    private void mapName(Map<String, String> name) {
        String first = name.get("first");
        String middle = name.get("middle");
        String last = name.get("last");

        this.name = new Name(first, middle, last);
    }
    
    @JsonProperty("address")
    private void mapAddress(Map<String, String> address) {
        String city = address.get("city");
        String street = address.get("street");
        String state = address.get("state");
        String zip = address.get("zip");

        this.address = new Address(city, street, state, zip);
    }

    @JsonProperty("phone")
    private void mapPhone(List<Map<String, String>> phones) {
        ArrayList<Phone> phoneNumbers = new ArrayList<>();

        for (Map<String, String> phone : phones) {
            String number = phone.get("number");
            PhoneType phoneType = PhoneType.valueOf(phone.get("type"));
            phoneNumbers.add(new Phone(number, phoneType));
        }

        this.phone = phoneNumbers;
    }
}