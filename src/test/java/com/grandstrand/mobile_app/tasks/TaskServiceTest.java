package com.grandstrand.mobile_app.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    
    private TaskService taskService;
    
    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }
    
    @Test
    void testAddTaskSuccess() {
        Task task = new Task("1234567890", "TaskName", "Valid description.");
        taskService.addTask(task);
        
        Task retrievedTask = taskService.getTask("1234567890");
        assertNotNull(retrievedTask);
        assertEquals("TaskName", retrievedTask.getName());
        assertEquals("Valid description.", retrievedTask.getDescription());
    }
    
    @Test
    void testAddTaskDuplicateID() {
        Task task1 = new Task("1234567890", "TaskName", "Valid description.");
        Task task2 = new Task("1234567890", "AnotherTask", "Another description.");
        
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }
    
    @Test
    void testDeleteTaskSuccess() {
        Task task = new Task("1234567890", "TaskName", "Valid description.");
        taskService.addTask(task);
        
        taskService.deleteTask("1234567890");
        assertNull(taskService.getTask("1234567890"));
    }
    
    @Test
    void testDeleteTaskNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("NonExistentID");
        });
    }
    
    @Test
    void testUpdateTaskNameByIdSuccess() {
        Task task = new Task("1234567890", "OldName", "Valid description.");
        taskService.addTask(task);
        
        boolean updated = taskService.updateTaskNameById("1234567890", "NewTaskName");
        assertTrue(updated);
        Task updatedTask = taskService.getTask("1234567890");
        assertEquals("NewTaskName", updatedTask.getName());
    }
    
    @Test
    void testUpdateTaskNameByIdNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskNameById("NonExistentID", "NewTaskName");
        });
    }
    
    @Test
    void testUpdateTaskDescriptionByIdSuccess() {
        Task task = new Task("1234567890", "TaskName", "Old description.");
        taskService.addTask(task);
        
        boolean updated = taskService.updateTaskDescriptionById("1234567890", "New description.");
        assertTrue(updated);
        Task updatedTask = taskService.getTask("1234567890");
        assertEquals("New description.", updatedTask.getDescription());
    }
    
    @Test
    void testUpdateTaskDescriptionByIdNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescriptionById("NonExistentID", "New description.");
        });
    }
}
