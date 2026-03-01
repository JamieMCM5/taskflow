package com.jamiemcmenemy.taskflow.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.jamiemcmenemy.taskflow.model.Task;
import com.jamiemcmenemy.taskflow.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    TaskService taskService;
    
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getTaskByID(id);
    }
    @PostMapping
    public String testPost(){
        return "tasks post";
    }
    
    @PutMapping
    public String testPut(){
        return "tasks put";
    }

    @DeleteMapping
    public String testDelete(){
        return "tasks delete";
    }
}