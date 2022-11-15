package com.maveric.userservice.Service;

import com.maveric.userservice.Entity.User;
import com.maveric.userservice.dao.UserRepository;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exception.UserNotFoundForIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(String userId) throws UserNotFoundForIdException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundForIdException("No User found for given Id");

        }
        return user.get();
    }
}
