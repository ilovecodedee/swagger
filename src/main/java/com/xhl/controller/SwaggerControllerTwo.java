package com.xhl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swaggerTwo")
public class SwaggerControllerTwo {

    @GetMapping("two")
    public String two(String name){
        System.out.println(name);
        return name;
    }
}
