package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto getUserDetailsByEmail(String emailId);

    public UserDto createUser(UserDto userDto);

}
