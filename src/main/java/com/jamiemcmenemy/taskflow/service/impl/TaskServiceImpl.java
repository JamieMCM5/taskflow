package com.jamiemcmenemy.taskflow.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jamiemcmenemy.taskflow.dto.TaskDto;
import com.jamiemcmenemy.taskflow.mapper.TaskMapper;
import com.jamiemcmenemy.taskflow.repository.TaskRepository;
import com.jamiemcmenemy.taskflow.service.TaskService;
import com.jamiemcmenemy.taskflow.entity.Task;
import com.jamiemcmenemy.taskflow.exceptions.ResourceNotFoundException;

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

    @Override
    public TaskDto getTaskByID(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task with given ID does not exist. " + taskId));
        TaskDto foundTask = TaskMapper.mapToTaskDto(task);
        return foundTask;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDto> taskDtos = tasks.stream().map((task) -> TaskMapper.mapToTaskDto(task))
            .collect(Collectors.toList());
            
        return taskDtos;
    }

    
    @Override
    public void deleteTask(Long taskId){
        @SuppressWarnings("unused")
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new ResourceNotFoundException("Task with given ID does not exist. " + taskId));
        taskRepository.deleteById(taskId);
    }
    

    @Override
    public void deleteAllTasks(){
        taskRepository.deleteAll();
    }
    
    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(
            () -> new ResourceNotFoundException("Task with given ID does not exist. " + taskId)
        );
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.getCompleted());
        
        Task updatedTaskObj = taskRepository.save(task);
        
        return TaskMapper.mapToTaskDto(updatedTaskObj);
    }
}
