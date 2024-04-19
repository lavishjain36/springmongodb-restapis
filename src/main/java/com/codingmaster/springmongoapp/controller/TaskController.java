package com.codingmaster.springmongoapp.controller;

import com.codingmaster.springmongoapp.entity.Task;
import com.codingmaster.springmongoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    // POST endpoint to create a new task
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Sets the HTTP status code to 201 (Created)
    public Task createTask(@RequestBody Task task){
        // Delegate the task creation to the service layer
        return service.addTask(task);
    }

    // GET endpoint to retrieve all tasks
    @GetMapping
    public List<Task> getTasks() {
        // Delegate fetching all tasks to the service layer
        return service.findAllTasks();
    }

    // GET endpoint to retrieve a task by its ID
    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        // Delegate fetching a task by ID to the service layer
        return service.getTaskByTaskId(taskId);
    }

    // GET endpoint to retrieve tasks by severity level
    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity){
        // Delegate fetching tasks by severity to the service layer
        return service.getTaskBySeverity(severity);
    }

    // GET endpoint to retrieve tasks by assignee
    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee){
        // Delegate fetching tasks by assignee to the service layer
        return service.getTaskByAssignee(assignee);
    }

    // PUT endpoint to modify/update a task
    @PutMapping
    public Task modifyTask(@RequestBody Task task){
        // Delegate task modification to the service layer
        return service.updateTask(task);
    }

    // DELETE endpoint to delete a task by its ID
    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        // Delegate task deletion to the service layer
        return service.deleteTask(taskId);
    }


}
