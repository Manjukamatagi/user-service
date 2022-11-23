package com.maveric.userservice.service;

import com.maveric.userservice.exception.UserNotFoundException;
import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.maveric.userservice.constants.Constants.USER_DELETED_SUCCESS;
import static com.maveric.userservice.constants.Constants.USER_NOT_FOUND_MESSAGE;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;


    @Override
    public String deleteUser(String userId) {
        if (repository.findById(userId).isEmpty()) {
            log.info("UserId does not exist! Cannot delete User details.");
            throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE + userId);
        }
        repository.deleteById(userId);
        log.info("Deleted user details for given UserId");
        return USER_DELETED_SUCCESS;
    }

}
