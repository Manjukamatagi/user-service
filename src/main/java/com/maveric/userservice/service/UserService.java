package com.maveric.userservice.service;

import com.maveric.userservice.customHandler.EmailDuplicationException;
import com.maveric.userservice.customHandler.PhoneNumberDuplicateException;
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

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    //Create user
    public UserResponse createUser(UserRequest userRequest) {
        User userToSave = beforeCreateUser(userRequest);
        if(!(userRepository.findByEmail(userRequest.getEmail()) == null)){
            throw new EmailDuplicationException(userRequest.getEmail());
        }
        if(!(userRepository.findByPhoneNumber(userRequest.getPhoneNumber()) == null)){
            throw new PhoneNumberDuplicateException(userRequest.getPhoneNumber());
        }
        User savedUser = userRepository.save(userToSave);
        return modelMapper.map(savedUser,UserResponse.class);
    }
    public User beforeCreateUser(UserRequest userRequest){
        User user = modelMapper.map(userRequest,User.class);
       // user.setId(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
//        String encodedPassword = PasswordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
        return user;
    }




}
