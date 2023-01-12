package com.maveric.userservice.service.impl;

import com.maveric.userservice.exception.UserNotFoundException;
import com.maveric.userservice.repository.UserRepository;
import com.maveric.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("User not found with id " + id));
        userRepository.deleteById(id);
    }
}
