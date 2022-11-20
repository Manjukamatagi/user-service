package com.maveric.userservice.service;

import com.maveric.userservice.customHandler.UserNotFoundWithGivenEmailException;
import com.maveric.userservice.dao.UserRepository;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.entity.User;
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
    public UserResponse getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user==null){
            throw new UserNotFoundWithGivenEmailException(email);
        }
        return modelMapper.map(userRepository.findByEmail(email),UserResponse.class);
    }

}
