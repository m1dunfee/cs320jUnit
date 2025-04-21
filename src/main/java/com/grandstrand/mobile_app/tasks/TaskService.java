package com.grandstrand.mobile_app.tasks;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // In-memory storage for tasks
    private Map<String, Task> tasks = new HashMap<>();
    
    // Add a new task ensuring the task ID is unique
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasks.put(task.getTaskID(), task);
    }
    
    // Delete a task by task ID
    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        tasks.remove(taskID);
    }
    
    // Update the task name by task ID
    public boolean updateTaskNameById(String taskID, String name) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        task.setName(name);
        return true;
    }
    
    // Update the task description by task ID
    public boolean updateTaskDescriptionById(String taskID, String description) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        task.setDescription(description);
        return true;
    }
    
    // Optionally, a method to retrieve a task by ID
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}
