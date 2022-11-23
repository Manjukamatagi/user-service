package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;

public interface UserService {
    public UserDto updateUser(String userId, UserDto userDto);
}
