package com.grandstrand.mobile_app.contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // In-memory storage for contacts
    private Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact, ensuring the ID is unique
    public void addContact(Contact contact) {
        if(contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        if(!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contacts.remove(contactID);
    }

    public void updateContactFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contact.setFirstName(firstName);
    }

    // Update only the last name of the contact
    public void updateContactLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contact.setLastName(lastName);
    }

    // Update only the phone number of the contact
    public void updateContactPhone(String contactId, String number) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contact.setPhone(number);
    }

    // Update only the address of the contact
    public void updateContactAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contact.setAddress(address);
    }
    
    // Optionally, a method to retrieve a contact
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
