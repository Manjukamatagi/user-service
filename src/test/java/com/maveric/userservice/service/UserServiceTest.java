package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exception.UserAlreadyExistException;
import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static com.maveric.userservice.UserServiceApplicationTests.getUser;
import static com.maveric.userservice.UserServiceApplicationTests.getUserDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

//    @BeforeAll
//    public void setUp(){
//        repository = Mockito.mock(UserRepository.class);
//
//    }

    @Test
    void createUser() {
        when(mapper.map(any(UserDto.class))).thenReturn(getUser());
        when(mapper.map(any(User.class))).thenReturn(getUserDto());
        when(repository.save(any())).thenReturn(getUser());
        UserDto userDto = service.createUser(getUserDto());
        assertSame(userDto.getFirstName(), getUser().getFirstName());
    }
    @Test
    void createUser_failure() {
        when(repository.findByEmail(any(String.class))).thenReturn(getUser());
        Throwable error = assertThrows(UserAlreadyExistException.class,()->service.createUser(getUserDto())); //NOSONAR
        assertEquals("User Already Exist! for this emailId",error.getMessage());    }

}
