package com.maveric.userservice.Service;

import com.maveric.userservice.Entity.User;
import com.maveric.userservice.dao.UserRepository;
import com.maveric.userservice.dto.UserDto;
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
    public List<User> getAllUsers() {
        List<User> list=userRepository.findAll();
        return list;
    }

    @Override
    public String createUser(User user) {
        User user1=userRepository.save(user);
        return "Created user";
    }

}
