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
@RequestMapping(value = "users")
public class userController {
    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;


    /**
     * Create user done
     */

    @PostMapping
    public String createUser(@RequestBody  User user){


        String msg=
                userService.createUser(user);
        return msg;

    }


}
