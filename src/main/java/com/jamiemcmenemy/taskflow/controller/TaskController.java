package com.jamiemcmenemy.taskflow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jamiemcmenemy.taskflow.dto.TaskDto;
import com.jamiemcmenemy.taskflow.service.TaskService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDto){
        TaskDto createdTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId){
        TaskDto foundTask = taskService.getTaskByID(taskId);
        return ResponseEntity.ok(foundTask);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(
        @PathVariable("id") Long taskId,
        @RequestParam boolean confirm){
        if (!confirm) {
            return ResponseEntity.badRequest().body("Please confirm deletion.");
        }
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task " + taskId +" Deleted successfully");
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteAllTasks(
        @RequestParam boolean confirm
    ){
        if (!confirm) {
            return ResponseEntity.badRequest().body("Please confirm deletion.");
        }
        taskService.deleteAllTasks();
        return ResponseEntity.ok("Deleted all tasks successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long taskId, @Valid @RequestBody TaskDto updatedTask){
        TaskDto taskDto = taskService.updateTask(taskId, updatedTask);
        return ResponseEntity.ok(taskDto);
    }
}