package com.maveric.userservice.controller;

import com.maveric.userservice.Entity.User;
import com.maveric.userservice.Service.UserService;
import com.maveric.userservice.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/users")
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
    public ResponseEntity createUser(@RequestBody @Valid User user){

        User user1 = userService.createUser(user);
        UserDto responseDto = new UserDto();
        responseDto.set_Id(user1.get_Id());
        responseDto.setGender(user1.getGender());
        responseDto.setAddress(user1.getAddress());
        responseDto.setEmail(user1.getEmail());
        responseDto.setFirstName(user1.getFirstName());
        responseDto.setLastName(user1.getLastName());
        responseDto.setMiddleName(user1.getMiddleName());
        responseDto.setDateOfBirth(user1.getDateOfBirth());
//        responseDto.getPhoneNumber(user1.getPhoneNumber());
        HttpHeaders reHttpHeaders = new HttpHeaders();
//        resonseHeaders.add("message", "user created successfully");
        return new ResponseEntity(responseDto, reHttpHeaders, HttpStatus.CREATED);

//
//        if(user.getFirstName().isEmpty() || user.getLastName().isEmpty()){
//            throw new UserNotCreatedException();
//        }
//        User user1 = userService.createUser(user);
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add("messge", "User created");
//        return new ResponseEntity (user1, responseHeaders, HttpStatus.CREATED);
    }

}
