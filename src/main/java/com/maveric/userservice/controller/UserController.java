package com.maveric.userservice.controller;


import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class UserController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getUsers(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        List<UserDto> userResponse = userService.getUsers(page,pageSize);
        log.info("API call returning list of All Users");
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}

