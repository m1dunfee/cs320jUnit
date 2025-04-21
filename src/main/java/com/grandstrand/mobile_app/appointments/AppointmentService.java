package com.grandstrand.mobile_app.appointments;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    // In-memory storage for appointments
    private Map<String, Appointment> appointments = new HashMap<>();

    /**
     * Adds an appointment if the appointment ID is unique.
     * 
     * @param appointment the Appointment object to add.
     * @throws IllegalArgumentException if an appointment with the same ID already exists.
     */
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    /**
     * Deletes an appointment by appointment ID.
     * 
     * @param appointmentID the ID of the appointment to delete.
     * @throws IllegalArgumentException if no appointment exists with the given ID.
     */
    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointments.remove(appointmentID);
    }

    // Optionally, a method to retrieve an appointment
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}
