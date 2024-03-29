package com.maveric.userservice.Service;


import com.maveric.userservice.Entity.User;
import com.maveric.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    String createUser(User user);
    User getUserById(Integer userId);
    User updateUser(Integer userId, User user) ;
    String deleteUser(Integer userId);
    User getUserByEmail(String email);



}
