package com.codingmaster.springmongoapp.service;


import com.codingmaster.springmongoapp.entity.Task;
import com.codingmaster.springmongoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    //CRUD: CREATE, READ, UPDATE, DELETE

    // This method adds a new task to the database.
    public Task addTask(Task task) {
        // Generate a unique ID for the task.
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        // Save the task to the database.
        return repository.save(task);
    }

    // This method fetches all tasks from the database.
    public List<Task> findAllTasks() {
        // Retrieve all tasks from the database using the repository.
        return repository.findAll();
    }

    // This method fetches a task by its unique task ID.
    public Task getTaskByTaskId(String taskId){
        // Find a task by its ID using the repository and return it.
        return repository.findById(taskId).get();
    }

    // This method fetches tasks based on their severity level.
    public List<Task> getTaskBySeverity(int severity){
        // Find tasks by severity using the repository and return them.
        return  repository.findBySeverity(severity);
    }

    // This method fetches tasks assigned to a particular assignee.
    public List<Task> getTaskByAssignee(String assignee){
        // Find tasks by assignee using the repository and return them.
        return repository.getTasksByAssignee(assignee);
    }

    // This method updates an existing task in the database.
    public Task updateTask(Task taskRequest){
        // Fetch the existing task from the database based on its ID.
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();

        // Update the existing task's fields with the new values from the request.
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());

        // Save the updated task back to the database.
        return repository.save(existingTask);
    }

    // This method deletes a task from the database based on its ID.
    public String deleteTask(String taskId){
        // Delete the task from the database using its ID.
        repository.deleteById(taskId);
        // Return a confirmation message.
        return taskId + " task deleted from dashboard ";
    }

}
