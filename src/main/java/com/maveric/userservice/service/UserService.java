package com.maveric.userservice.service;

import com.maveric.userservice.dao.UserRepository;
import com.maveric.userservice.dto.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    //Get user by EmailID
    public UserResponse getUserByEmail(String email){
        return modelMapper.map(userRepository.findByEmail(email),UserResponse.class);
    }




}
