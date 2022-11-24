package com.maveric.userservice.controller;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class UserController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    /* Returns list details by emailId */

    @GetMapping("users/getUserByEmail/{emailId}")
    public ResponseEntity<UserDto> getUserDetailsByEmail(@PathVariable String emailId) {
        log.info("API call returning list of User details for the given valid emailId");
        UserDto userDtoResponse = userService.getUserDetailsByEmail(emailId);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);
    }

    @PostMapping("users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        log.info("API call to create a new User");
        UserDto userDtoResponse = userService.createUser(userDto);
        log.info("User information Created successfully");
        userDtoResponse.setPassword(null);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.CREATED);
    }
}
