package com.maveric.userservice.service;

import com.maveric.userservice.dao.UserRepository;
import com.maveric.userservice.exception.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String USER_NOT_FOUND_MESSAGE ="User not Found for Id " ;
    private static final String USER_DELETED_SUCCESS = "User deleted successfully.";
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    //Delete user
    public void deleteUser(Long userId){
        if(userRepository.findById(userId).isEmpty()){
            System.out.println("UserId does not exist! Cannot delete User details.");
            throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE +  userId);
        }
        userRepository.deleteById(userId);
        System.out.println("Deleted user details for given UserId ");
    }
}