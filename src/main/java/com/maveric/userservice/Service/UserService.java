package com.maveric.userservice.Service;


import com.maveric.userservice.Entity.User;
import com.maveric.userservice.exception.UserNotFoundForIdException;

public interface UserService {
    User getUserById(String userId) throws UserNotFoundForIdException;
//    List<User> getAllUsers();

}
