package com.maveric.userservice.mapper;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="User")
public interface UserMapper {
    UserDto map(User user);
    User map(UserDto userDto);
    List<User> mapToModel (List<UserDto> userDtos);
    List<UserDto> mapToDto (List<User> users);


}
