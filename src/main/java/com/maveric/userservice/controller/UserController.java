package com.maveric.userservice.controller;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class UserController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /* Update User by UserId */
    @PutMapping("users/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        log.info("API call to Update User for valid userId");
        UserDto userDto1 = userService.updateUser(userId, userDto);
        log.info("User information Updated successfully");
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }

}
