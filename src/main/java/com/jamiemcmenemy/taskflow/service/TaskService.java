package com.jamiemcmenemy.taskflow.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.jamiemcmenemy.taskflow.repository.TaskRepository;
import com.jamiemcmenemy.taskflow.model.Task;
@Service
public class TaskService{
    private final TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public Task getTaskByID(Long id){
        return repository.getReferenceById(id);
    }
}