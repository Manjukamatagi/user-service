package com.maveric.userservice.mapper;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;

public class UserMapperImpl implements UserMapper{
    @Override
    public User map(UserDto userDto) {
        return new User(
                userDto.get_id(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getMiddleName(),
                userDto.getPhoneNumber(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getDateOfBirth(),
                userDto.getGender(),
                userDto.getRole(),
                userDto.getPassword()

        );
    }

    @Override
    public UserDto map(User user) {
        return new UserDto(
                user.get_id(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getAddress(),
                user.getDateOfBirth(),
                user.getGender(),
                user.getRole(),
                user.getPassword()
        );
    }
}
