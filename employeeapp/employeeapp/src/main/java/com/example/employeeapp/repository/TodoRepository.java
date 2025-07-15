package com.example.employeeapp.repository;

import com.example.employeeapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByEmployeeId(Long employeeId);
}
