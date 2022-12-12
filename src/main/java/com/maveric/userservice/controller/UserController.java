package com.maveric.userservice.controller;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;


@RequestMapping("/api/v1")
@RestController
public class UserController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    /* Returns list of All Users */
    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getUsers(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        List<UserDto> userRespons = userService.getUsers(page,pageSize);
        log.info("API call returning list of All Users");
        return new ResponseEntity<>(userRespons, HttpStatus.OK);
    }
    // creating new user record
    @PostMapping("users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        log.info("API call to create a new User");
        UserDto userDtoResponse = userService.createUser(userDto);
        log.info("User information Created successfully");
        userDtoResponse.setPassword(null);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.CREATED);
    }
}

