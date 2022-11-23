package com.maveric.userservice.mapper;


import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {


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
