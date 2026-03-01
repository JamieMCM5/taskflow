package com.jamiemcmenemy.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jamiemcmenemy.taskflow.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
