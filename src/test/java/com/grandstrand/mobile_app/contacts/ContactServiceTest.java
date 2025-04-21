package com.grandstrand.mobile_app.contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void setUp() {
        // Initialize a new ContactService before each test
        contactService = new ContactService();
    }

    @Test
    void testAddContactSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Verify the contact is stored
        Contact retrievedContact = contactService.getContact("1234567890");
        assertNotNull(retrievedContact);
        assertEquals("John", retrievedContact.getFirstName());
        assertEquals("Doe", retrievedContact.getLastName());
    }

    @Test
    void testAddContactDuplicateID() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "0987654321", "456 Elm St");
        
        contactService.addContact(contact1);
        // Adding contact2 with the same ID should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    void testDeleteContactSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.deleteContact("1234567890");
        // After deletion, retrieving the contact should return null
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    void testDeleteContactNonExistent() {
        // No contact with this ID
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("NonExistentID");
        });
    }
    
    @Test
    void testUpdateContactFirstNameSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContactFirstName("1234567890", "Johnny");
        Contact updatedContact = contactService.getContact("1234567890");
        
        assertEquals("Johnny", updatedContact.getFirstName());
    }
    
    @Test
    void testUpdateContactLastNameSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContactLastName("1234567890", "D");
        Contact updatedContact = contactService.getContact("1234567890");
        
        assertEquals("D", updatedContact.getLastName());
    }
    
    @Test
    void testUpdateContactPhoneSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContactPhone("1234567890", "0987654321");
        Contact updatedContact = contactService.getContact("1234567890");
        
        assertEquals("0987654321", updatedContact.getPhone());
    }
    
    @Test
    void testUpdateContactAddressSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContactAddress("1234567890", "456 Elm St");
        Contact updatedContact = contactService.getContact("1234567890");
        
        assertEquals("456 Elm St", updatedContact.getAddress());
    }
    
    @Test
    void testUpdateContactNonExistent() {
        // For each update method, trying to update a non-existent contact should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFirstName("NonExistentID", "Johnny");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactLastName("NonExistentID", "D");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactPhone("NonExistentID", "0987654321");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactAddress("NonExistentID", "456 Elm St");
        });
    }
}
