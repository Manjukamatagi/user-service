package com.maveric.userservice.Service;

import com.maveric.userservice.Entity.User;
import com.maveric.userservice.dao.UserRepository;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list=userRepository.findAll();
        return null;
    }

    @Override
    public User createUser(User user) {
       return userRepository.save(user);

    }

}
