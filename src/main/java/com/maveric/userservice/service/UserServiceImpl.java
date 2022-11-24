package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exception.UserAlreadyExistException;
import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import static com.maveric.userservice.constants.Constants.USER_DELETED_SUCCESS;
import static com.maveric.userservice.constants.Constants.USER_NOT_FOUND_MESSAGE;

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
    public UserDto getUserDetailsByEmail(String emailId) {
        User userResult = repository.findByEmail(emailId);
        if (userResult != null)
        {
            log.info("Retrieved list of user details for given emailId");
            return mapper.map(userResult);
        }
        else
        {
            log.info("User details does not exist! Returns empty User details.");
            return new UserDto();
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
