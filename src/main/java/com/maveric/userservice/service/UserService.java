package com.maveric.userservice.service;

import com.maveric.userservice.dao.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    //Delete user
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }


}