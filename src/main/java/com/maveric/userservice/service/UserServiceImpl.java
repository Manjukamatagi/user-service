package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exception.UserNotFoundException;
import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;


    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        if (userId.equals(userDto.get_id())) {
            User userResult = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
            userResult.set_id(userResult.get_id());
            userResult.setFirstName(userDto.getFirstName());
            userResult.setLastName(userDto.getLastName());
            userResult.setMiddleName(userDto.getMiddleName());
            userResult.setPhoneNumber(userDto.getPhoneNumber());
            userResult.setEmail(userDto.getEmail());
            userResult.setAddress(userDto.getAddress());
            userResult.setDateOfBirth(userDto.getDateOfBirth());
            userResult.setGender(userDto.getGender());
            User accountUpdated = repository.save(userResult);
            log.info("User details Updated Successfully for given UserId");
            return mapper.map(accountUpdated);
        } else {
            log.error("UserId does not exist! Cannot Update User details.");
            throw new UserNotFoundException("User Id not found! Cannot Update account.");
        }
    }
}
