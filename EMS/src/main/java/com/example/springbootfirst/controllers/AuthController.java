package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


//Authentication
@RestController
@RequestMapping("/employee")
public class AuthController {

    @Autowired
    EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee e){
        return employeeService.addEmployee(e);
    }
}
