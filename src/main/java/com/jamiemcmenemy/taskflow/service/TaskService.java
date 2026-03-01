package com.jamiemcmenemy.taskflow.service;

import com.jamiemcmenemy.taskflow.dto.TaskDto;
public interface TaskService{
    TaskDto createTask(TaskDto taskDto);
}