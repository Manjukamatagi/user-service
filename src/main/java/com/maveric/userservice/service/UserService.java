package com.maveric.userservice.service;

import com.maveric.userservice.dao.UserRepository;
import com.maveric.userservice.dto.UserRequest;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    //Create user
    public UserResponse createUser(UserRequest userRequest){
        User userToSave = beforeCreateUser(userRequest);
        User savedUser = userRepository.save(userToSave);
        return modelMapper.map(savedUser,UserResponse.class);
    }
    public User beforeCreateUser(UserRequest userRequest){
        User user = modelMapper.map(userRequest,User.class);
       // user.setId(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }


}
