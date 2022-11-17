package com.maveric.userservice.service;

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

    //Create user
   public UserResponse updateUser(UserRequest userRequest,Long userId){
       User userToUpdate = modelMapper.map(userRequest, User.class);
       userToUpdate.setId(userId);
       return modelMapper.map(userRepository.save(userToUpdate), UserResponse.class);
   }


}
