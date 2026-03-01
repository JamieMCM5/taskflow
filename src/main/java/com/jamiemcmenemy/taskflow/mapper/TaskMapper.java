package com.jamiemcmenemy.taskflow.mapper;

import com.jamiemcmenemy.taskflow.dto.TaskDto;
import com.jamiemcmenemy.taskflow.entity.Task;

/**
 * This class maps the data from the Task entity and the TaskDto object and vice versa for client-server data transfer.
 */
public class TaskMapper {
    public static TaskDto mapToTaskDto(Task task){
        return new TaskDto(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.isCompleted(),
            task.getCreatedAt()
        );
    }
    
    public static Task mapToTask(TaskDto taskDto){
        return new Task(
            taskDto.getId(),
            taskDto.getTitle(),
            taskDto.getDescription(),
            taskDto.getCompleted(),
            taskDto.getCreatedAt()
        );
    }
}
