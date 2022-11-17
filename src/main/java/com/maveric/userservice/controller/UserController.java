package com.maveric.userservice.controller;

import com.maveric.userservice.dto.UserRequest;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest, @RequestParam ("userId") Long userId){
        UserResponse response = userService.updateUser(userRequest,userId);
        return ResponseEntity.ok(response);
    }
}
