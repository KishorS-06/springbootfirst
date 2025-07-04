package com.example.first.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.first.services.HelloWorldServices;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldServices hws;

    @GetMapping("/")
    public String Hello() {
        return hws.getMessage();
    }
    
    @GetMapping("/")
    public String getMethod() {
    	return hws.getMessage();
    }
    
    @DeleteMapping("/")
    public String deleteMethod() {
    	return hws.deleteMessage();
    }
}