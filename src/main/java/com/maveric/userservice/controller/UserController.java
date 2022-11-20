package com.maveric.userservice.controller;

import com.maveric.userservice.customHandler.UserNotFoundWithGivenEmailException;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserByEmail/{emailId}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable("emailId") String emailId)
    throws UserNotFoundWithGivenEmailException {
        UserResponse userResponse = userService.getUserByEmail(emailId);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
//        return ResponseEntity.ok(userResponse);
    }
}
