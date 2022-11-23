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

    /* Returns list of user details by userId */
    @GetMapping("users/{userId}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable String userId) {
        log.info("API call returning list of User details for the given valid UserId");
        UserDto userDtoResponse = userService.getUserDetails(userId);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);

    }

}
