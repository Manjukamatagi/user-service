package com.maveric.userservice.Service;


import com.maveric.userservice.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);




}
