package com.example.employeeapp.service;

import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.entity.Todo;
import com.example.employeeapp.repository.EmployeeRepository;
import com.example.employeeapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TodoRepository todoRepository;

    public Employee updateEmployee(Long id, Employee updated) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(updated.getName());
            emp.setRole(updated.getRole());
            return employeeRepository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> findByRole(String role) {
        return employeeRepository.findByRole(role);
    }

    public List<Todo> getTodos(Long empId) {
        return todoRepository.findByEmployeeId(empId);
    }

    public Todo addTodo(Long empId, Todo todo) {
        Employee emp = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        todo.setEmployee(emp);
        return todoRepository.save(todo);
    }
}