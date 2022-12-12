package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;

import com.maveric.userservice.exception.UserNotFoundException;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exception.UserAlreadyExistException;

import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto getUserDetails(String userId) {
        User userResult = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        log.info("Retrieved list of user details for given UserId");
        return mapper.map(userResult);
    }

    public List<UserDto> getUsers(Integer page, Integer pageSize) {
        Pageable paging = PageRequest.of(page, pageSize);
        Page<User> pageResult = repository.findAll(paging);
        if (pageResult.hasContent()) {
            List<User> users = pageResult.getContent();
            log.info("Retrieved list of all users");
            return mapper.mapToDto(users);
        } else {
            log.error("No User info found!");
            return new ArrayList<>();
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        String pass = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(pass);
        User userResult = repository.findByEmail(userDto.getEmail());
        if (userResult == null) {
            User user = mapper.map(userDto);
            User userResult2 = repository.save(user);
            log.error("Created new user successfully");
            return mapper.map(userResult2);
        } else {
            log.error("User Already Exist for this emailId");
            throw new UserAlreadyExistException("User Already Exist! for this emailId");
        }
    }


}
