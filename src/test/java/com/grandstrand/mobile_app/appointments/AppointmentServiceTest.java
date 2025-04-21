package com.grandstrand.mobile_app.appointments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

public class AppointmentServiceTest {
    
    private AppointmentService appointmentService;
    
    // Helper method for a future date
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }
    
    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }
    
    @Test
    public void testAddAppointmentSuccess() {
        Appointment appointment = new Appointment("1234567890", getFutureDate(), "Consultation");
        appointmentService.addAppointment(appointment);
        Appointment retrieved = appointmentService.getAppointment("1234567890");
        assertNotNull(retrieved);
        assertEquals("Consultation", retrieved.getDescription());
    }
    
    @Test
    public void testAddAppointmentDuplicateID() {
        Appointment appointment1 = new Appointment("1234567890", getFutureDate(), "Consultation");
        Appointment appointment2 = new Appointment("1234567890", getFutureDate(), "Follow-up");
        appointmentService.addAppointment(appointment1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
        assertEquals("Appointment ID already exists.", exception.getMessage());
    }
    
    @Test
    public void testDeleteAppointmentSuccess() {
        Appointment appointment = new Appointment("1234567890", getFutureDate(), "Consultation");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("1234567890");
        assertNull(appointmentService.getAppointment("1234567890"));
    }
    
    @Test
    public void testDeleteAppointmentNonExistent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("NonExistent");
        });
        assertEquals("Appointment ID does not exist.", exception.getMessage());
    }
}
