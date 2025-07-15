package com.example.employeeapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloText {
    public void testHelloTest(){

        Hello hell=new Hello();
        String str=hell.helloTest();
        System.out.println(str);
        assertEquals("Hello Test",str);
    }
}