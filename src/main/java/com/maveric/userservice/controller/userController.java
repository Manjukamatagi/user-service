package com.maveric.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class userController {
    @GetMapping(value = "/hello")
    public String SayHello(){
        return "Hello, this is from user service";
    }
}
