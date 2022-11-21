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

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    //Update user
   public UserResponse updateUser(UserRequest userRequest,Long userId){
       User userToUpdate = modelMapper.map(userRequest, User.class);
       if(!(userRepository.findByEmail(userRequest.getEmail()) == null)){
           throw new EmailDuplicationException(userRequest.getEmail());
       }
       if(!(userRepository.findByPhoneNumber(userRequest.getPhoneNumber()) == null)){
           throw new PhoneNumberDuplicateException(userRequest.getPhoneNumber());
       }
       userToUpdate.setId(userId);
       return modelMapper.map(userRepository.save(userToUpdate), UserResponse.class);
   }

}
