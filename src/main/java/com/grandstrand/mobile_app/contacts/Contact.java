package com.grandstrand.mobile_app.contacts;

public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor with enhanced validations
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Validate contactID: must not be null and must be exactly 10 digits (only digits allowed)
        if (contactID == null || !contactID.matches("\\d{10}")) {
            throw new IllegalArgumentException("Contact ID must be exactly 10 digits and not null.");
        }
        // Validate firstName: must not be null and (optionally) have a maximum length, e.g., 10 characters
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be not null and at most 10 characters.");
        }
        // Validate lastName: must not be null and must not exceed 10 characters
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be not null and at most 10 characters.");
        }
        // Validate phone: must not be null and must be exactly 10 digits (only digits allowed)
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone field must be exactly 10 digits and not null.");
        }
        // Validate address: must not be null
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    // Setters with corresponding validations
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be not null and at most 10 characters.");
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be not null and at most 10 characters.");
        }
        this.lastName = lastName;
    }
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone field must be exactly 10 digits and not null.");
        }
        this.phone = phone;
    }
    public void setAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        this.address = address;
    }
}
