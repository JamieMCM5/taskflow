package com.jamiemcmenemy.taskflow.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * TaskDto is a class used to transfer data between the client and the server.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime createdAt; 
}
