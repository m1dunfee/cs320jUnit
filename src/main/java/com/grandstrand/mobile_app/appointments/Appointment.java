package com.grandstrand.mobile_app.appointments;

import java.util.Date;

public class Appointment {
    // The appointment ID is final because it cannot be updated.
    private final String appointmentID;
    private Date appointmentDate;
    private String description;

    /**
     * Constructs an Appointment.
     * 
     * @param appointmentID a unique ID that must not be null and must be no longer than 10 characters,
     *                      consisting solely of digits.
     * @param appointmentDate a Date that must not be null and cannot be in the past.
     * @param description a String that must not be null and must not exceed 50 characters.
     */
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        // Validate appointmentID: not null, no longer than 10 characters, and only digits.
        if (appointmentID == null || !appointmentID.matches("\\d{1,10}")) {
            throw new IllegalArgumentException("Appointment ID must not be null and must be at most 10 digits.");
        }
        // Validate appointmentDate: not null and cannot be in the past.
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must not be null and cannot be in the past.");
        }
        // Validate description: not null and not longer than 50 characters.
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be at most 50 characters.");
        }
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
    
    // If needed, you can add setters for appointmentDate and description,
    // but note that appointmentID is not updatable.
}
