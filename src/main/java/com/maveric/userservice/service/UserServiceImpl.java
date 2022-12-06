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

@Service
public class UserServiceImpl implements UserService{
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper mapper;
    @Autowired
    UserRepository repository;
    @Override
    public UserDto createUser(UserDto userDto) {
        String pass = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(pass);
        if(repository.findByEmail(userDto.getEmail()) != null){
            throw new UserAlreadyExistException("User Already Exist for this EmailId");
        }else if(repository.findByPhoneNumber(userDto.getPhoneNumber()) != null) {
            throw new UserAlreadyExistException("User Already Exist for this Phone number");
        }else{
            User user = mapper.map(userDto);
            User userResult2 = repository.save(user);
            log.info("Created new user successfully");
            return mapper.map(userResult2);
        }
    }
}
