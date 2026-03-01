package com.jamiemcmenemy.taskflow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jamiemcmenemy.taskflow.dto.TaskDto;
import com.jamiemcmenemy.taskflow.service.TaskService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    private TaskService taskService;
    
    // Build add task rest API

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        TaskDto createdTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId){
        TaskDto foundTask = taskService.getTaskByID(taskId);
        return ResponseEntity.ok(foundTask);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
}