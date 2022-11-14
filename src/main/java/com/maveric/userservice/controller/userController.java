package com.maveric.userservice.controller;

import com.maveric.userservice.Entity.User;
import com.maveric.userservice.Service.UserService;
import com.maveric.userservice.UserNotCreatedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
@ResponseBody
public class userController {
    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;


    /**
     * Create user done
     */

    @PostMapping
    public ResponseEntity createUser(@RequestBody  User user){
        if(user.getFirstName().isEmpty() || user.getLastName().isEmpty()){
            throw new UserNotCreatedException();
        }
        User user1 = userService.createUser(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("messge", "User created");
        return new ResponseEntity (user1, responseHeaders, HttpStatus.CREATED);
    }

}
