package com.jamiemcmenemy.taskflow.service.impl;

import org.springframework.stereotype.Service;

import com.jamiemcmenemy.taskflow.dto.TaskDto;
import com.jamiemcmenemy.taskflow.mapper.TaskMapper;
import com.jamiemcmenemy.taskflow.repository.TaskRepository;
import com.jamiemcmenemy.taskflow.service.TaskService;
import com.jamiemcmenemy.taskflow.entity.Task;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = TaskMapper.mapToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);    
    }
    
}
