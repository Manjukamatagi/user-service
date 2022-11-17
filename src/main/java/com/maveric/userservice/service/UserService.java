package com.maveric.userservice.service;

import com.maveric.userservice.dao.UserRepository;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    //Get user
    public UserResponse getUser(Long userId){
       Optional<User> user = userRepository.findById(userId);
       return modelMapper.map(user.get(),UserResponse.class);

    }




}
