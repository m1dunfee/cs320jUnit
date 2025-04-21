package com.grandstrand.mobile_app.tasks;

public class Task {
    // Constants for field limits
    private static final int MAX_TASK_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 20;
    private static final int MAX_DESCRIPTION_LENGTH = 50;
    
    // Fields
    private final String taskID; // immutable once set
    private String name;
    private String description;
    
    // Constructor enforcing constraints
    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > MAX_TASK_ID_LENGTH) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Invalid description");
        }
        
        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }
    
    // Getters (no setter for taskID, as it's final)
    public String getTaskID() {
        return taskID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    // Setters for updatable fields with validation
    public void setName(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }
    
    public void setDescription(String description) {
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
