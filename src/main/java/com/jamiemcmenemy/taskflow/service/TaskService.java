package com.jamiemcmenemy.taskflow.service;

import java.util.List;

import com.jamiemcmenemy.taskflow.dto.TaskDto;
public interface TaskService{
    TaskDto createTask(TaskDto taskDto);
    TaskDto getTaskByID(Long taskId);
    List<TaskDto> getAllTasks();
}