package com.jamiemcmenemy.taskflow.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Title cannot be blank")
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt; 
}
