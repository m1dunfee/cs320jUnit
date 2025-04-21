package com.grandstrand.mobile_app.contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactConstructorValid() {
        // Valid contact
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactConstructorInvalidContactID() {
        // Should throw IllegalArgumentException because ID is too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testContactConstructorNullFirstName() {
        // Should throw IllegalArgumentException because firstName is null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testContactConstructorTooLongLastName() {
        // Should throw IllegalArgumentException because lastName is more than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "LastNameIsTooLong", "1234567890", "123 Main St");
        });
    }

    @Test
    void testContactConstructorInvalidPhoneLength() {
        // Should throw IllegalArgumentException because phone length is not exactly 10
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "12345", "123 Main St");
        });
    }

    @Test
    void testContactConstructorNullAddress() {
        // Should throw IllegalArgumentException because address is null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    void testSettersValid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    void testSettersInvalidFirstName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisNameIsWayTooLong");
        });
    }

}
