package com.maveric.userservice.controller;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.maveric.userservice.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        userDto.setPassword(this.bCryptPasswordEncoder.encode(userDto.getPassword()));
        return new ResponseEntity<UserDto>(userService.createUser(userDto), HttpStatus.CREATED);
    }
    
    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("userId") long userId, @RequestBody UserDto userDto) {
        return new ResponseEntity<UserDto>(userService.updateUser(userDto, userId), HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                     @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {
        return userService.getAllUsers(page, pageSize);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") long id) {
        return new ResponseEntity<UserDto>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/users/getUserByEmail/{emailId}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("emailId") String email){
        return new ResponseEntity<UserDto>(userService.getUserByEmail(email), HttpStatus.OK);
    }
}
