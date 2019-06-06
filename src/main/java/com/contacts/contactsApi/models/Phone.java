package com.contacts.contactsApi.models;

import javax.persistence.Embeddable;

import com.contacts.contactsApi.models.constants.PhoneType;

@Embeddable
public class Phone {
    private String number;
    private PhoneType type;

    public Phone() {
        // Do not remove, required for deserialization
    }

    public Phone(String number, PhoneType phoneType) {
        this.number = number;
        this.type = phoneType;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the phoneType
     */
    public PhoneType getType() {
        return type;
    }

    /**
     * @param phoneType the phoneType to set
     */
    public void setType(PhoneType phoneType) {
        this.type = phoneType;
    }
}
