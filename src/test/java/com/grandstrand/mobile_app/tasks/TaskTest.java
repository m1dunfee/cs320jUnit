package com.grandstrand.mobile_app.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    void testTaskConstructorValid() {
        Task task = new Task("1234567890", "TaskName", "This is a valid description.");
        assertEquals("1234567890", task.getTaskID());
        assertEquals("TaskName", task.getName());
        assertEquals("This is a valid description.", task.getDescription());
    }

    @Test
    void testTaskConstructorInvalidTaskID() {
        // Task ID too long should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "TaskName", "Valid description.");
        });
    }
    
    @Test
    void testTaskConstructorNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", null, "Valid description.");
        });
    }
    
    @Test
    void testTaskConstructorTooLongName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "NameIsWayTooLongForThisTask", "Valid description.");
        });
    }
    
    @Test
    void testTaskConstructorInvalidDescription() {
        // Description exceeding 50 characters
        String longDescription = "This description is way too long to be acceptable for a task object.";
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "TaskName", longDescription);
        });
    }
    
    @Test
    void testSettersValid() {
        Task task = new Task("1234567890", "TaskName", "Valid description.");
        task.setName("NewName");
        task.setDescription("New description.");
        
        assertEquals("NewName", task.getName());
        assertEquals("New description.", task.getDescription());
    }
    
    @Test
    void testSettersInvalidName() {
        Task task = new Task("1234567890", "TaskName", "Valid description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("ThisNameIsDefinitelyWayTooLongForTheTask");
        });
    }
    
    @Test
    void testSettersInvalidDescription() {
        Task task = new Task("1234567890", "TaskName", "Valid description.");
        String longDescription = "This description is definitely more than fifty characters in length.";
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(longDescription);
        });
    }
}
