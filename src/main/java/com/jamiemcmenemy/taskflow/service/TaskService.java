package com.jamiemcmenemy.taskflow.service;

import java.util.List;

import com.jamiemcmenemy.taskflow.dto.TaskDto;
public interface TaskService{
    TaskDto createTask(TaskDto taskDto);
    TaskDto getTaskByID(Long taskId);
    List<TaskDto> getAllTasks();
    void deleteTask(Long taskId);
    void deleteAllTasks();
    TaskDto updateTask(Long taskId, TaskDto updatedTask);
}