package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.TaskAssigned;
import com.example.springbootfirst.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public Map<Integer, String> taskAssignedList(){
        return taskService.taskAssignedList();
    }

    @PostMapping("/assignTask")
    public String assignTask(@RequestBody TaskAssigned t){
        return taskService.assignTask(t);
    }
}
