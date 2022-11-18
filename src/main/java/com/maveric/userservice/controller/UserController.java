package com.maveric.userservice.controller;

import com.maveric.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> createUser( @PathVariable ("userId") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("Success");
    }
}
