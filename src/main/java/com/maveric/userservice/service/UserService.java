package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getUsers(Integer page, Integer pageSize);

}
