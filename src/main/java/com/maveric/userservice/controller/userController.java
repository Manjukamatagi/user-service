package com.maveric.userservice.controller;

import com.maveric.userservice.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class userController {
    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    /**
     * Get ALL USERS
     * @return
     */
//    @GetMapping(value="/{id}")
//    public List<User> getAllUsers(){
//        System.out.println("hi this is from get all user");
//        return userService.getAllUsers();
//
//    }

    @GetMapping
    public ResponseEntity <User>getUserById(@PathVariable("Id")String userId) UserNotFoundForIdException{
        User user = userService.getAllUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }


}
