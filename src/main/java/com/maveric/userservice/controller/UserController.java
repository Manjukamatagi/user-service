package com.maveric.userservice.controller;

import com.maveric.userservice.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController

public class UserController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /* Deleting user by userId */
    @DeleteMapping("users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        log.info("API call to delete User based on UserId");
        String result = userService.deleteUser(userId);
        log.info("User deleted successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
