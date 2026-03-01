package com.jamiemcmenemy.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jamiemcmenemy.taskflow.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
