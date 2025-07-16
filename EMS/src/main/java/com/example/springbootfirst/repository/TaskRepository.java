package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.TaskAssigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskAssigned, Integer> {
}
