package com.maveric.userservice.mapper;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.mapstruct.Mapper;
@Mapper(componentModel="User")
public interface UserMapper {

    UserDto map(User user);
}

