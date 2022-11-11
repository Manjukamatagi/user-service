package com.maveric.userservice.Service;


import com.maveric.userservice.Entity.User;
import com.maveric.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

}
