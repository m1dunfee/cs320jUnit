package com.grandstrand.mobile_app.appointments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

public class AppointmentTest {
    
    // Helper method to get a future date (e.g., 1 day from now)
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }
    
    // Helper method to get a past date (e.g., 1 day ago)
    private Date getPastDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return cal.getTime();
    }
    
    @Test
    public void testValidAppointment() {
        Appointment appointment = new Appointment("1234567890", getFutureDate(), "Team meeting");
        assertNotNull(appointment);
        assertEquals("1234567890", appointment.getAppointmentID());
        assertEquals("Team meeting", appointment.getDescription());
    }
    
    @Test
    public void testAppointmentIDTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", getFutureDate(), "Team meeting");
        });
        assertEquals("Appointment ID must not be null and must be at most 10 digits.", exception.getMessage());
    }
    
    @Test
    public void testAppointmentIDNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, getFutureDate(), "Team meeting");
        });
        assertEquals("Appointment ID must not be null and must be at most 10 digits.", exception.getMessage());
    }
    
    @Test
    public void testAppointmentDateInPast() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", getPastDate(), "Team meeting");
        });
        assertEquals("Appointment date must not be null and cannot be in the past.", exception.getMessage());
    }
    
    @Test
    public void testAppointmentDateNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Team meeting");
        });
        assertEquals("Appointment date must not be null and cannot be in the past.", exception.getMessage());
    }
    
    @Test
    public void testDescriptionTooLong() {
        String longDescription = "This description is definitely more than fifty characters long and will fail.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", getFutureDate(), longDescription);
        });
        assertEquals("Description must not be null and must be at most 50 characters.", exception.getMessage());
    }
    
    @Test
    public void testDescriptionNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", getFutureDate(), null);
        });
        assertEquals("Description must not be null and must be at most 50 characters.", exception.getMessage());
    }
}
