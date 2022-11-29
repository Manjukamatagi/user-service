package com.maveric.userservice.mapper;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.maveric.userservice.UserServiceApplicationTests.getUser;
import static com.maveric.userservice.UserServiceApplicationTests.getUserDto;

class UserMapperImplTest {
    UserMapperImpl userMapper=new UserMapperImpl();
    @Test
    void map() {
        UserDto userDto=getUserDto();
        User user = userMapper.map(userDto);
        Assertions.assertEquals(userDto.getGender(), user.getGender());
        Assertions.assertEquals(userDto.get_id(), user.get_id());
    }

    @Test
    void testMap() {
        User user=getUser();
        UserDto userdto = userMapper.map(user);
        Assertions.assertEquals(user.getGender(), userdto.getGender());
        Assertions.assertEquals(user.get_id(), userdto.get_id());
    }
}