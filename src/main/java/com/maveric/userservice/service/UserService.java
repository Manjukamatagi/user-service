package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, long userId);
}
