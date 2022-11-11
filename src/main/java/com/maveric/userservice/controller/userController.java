package com.maveric.userservice.controller;

import com.maveric.userservice.Entity.User;
import com.maveric.userservice.Service.UserService;
import com.maveric.userservice.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping(value="")
    public List<User> getAllUsers(){
        System.out.println("hi this is from get all user");
        return userService.getAllUsers();

    }

}
