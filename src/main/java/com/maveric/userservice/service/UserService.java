package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto getUserDetails(String userId);
    public List<UserDto> getUsers(Integer page, Integer pageSize);
    public UserDto createUser(UserDto userDto);

}
