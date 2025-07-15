package com.example.employeeapp.controller;

import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.entity.Todo;
import com.example.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @GetMapping("/role/{role}")
    public List<Employee> getByRole(@PathVariable String role) {
        return service.findByRole(role);
    }

    @GetMapping("/{id}/todos")
    public List<Todo> getTodos(@PathVariable Long id) {
        return service.getTodos(id);
    }

    @PostMapping("/{id}/todos")
    public Todo addTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return service.addTodo(id, todo);
    }
}