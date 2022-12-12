package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;

import com.maveric.userservice.enumeration.Gender;

import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import java.util.Optional;

import static com.maveric.userservice.UserServiceApplicationTests.getUser;
import static com.maveric.userservice.UserServiceApplicationTests.getUserDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.BDDMockito.willDoNothing;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    @Mock
    private Page pageResult;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void getUserDetails() {
        when(repository.findById("2")).thenReturn(Optional.of(getUser()));
        when(mapper.map(any(User.class))).thenReturn(getUserDto());
        UserDto userDto = service.getUserDetails("2");
        assertSame(userDto.getFirstName(),getUserDto().getFirstName());

      }

    @Test
    void getUsers() {
        Page<User> pagedResponse = new PageImpl(Arrays.asList(getUser(),getUser()));
        when(repository.findAll(any(Pageable.class))).thenReturn(pagedResponse);
        when(mapper.mapToDto(any())).thenReturn(Arrays.asList(getUserDto(),getUserDto()));
        List<UserDto> users = service.getUsers(1,1);

        assertEquals("Manju", users.get(0).getFirstName());
        assertEquals(Gender.MALE, users.get(1).getGender());
    }
    @Test
    void getUsers_failure() {
        Page<User> pagedResponse = new PageImpl(Arrays.asList());
        when(repository.findAll(any(Pageable.class))).thenReturn(pagedResponse);
        List<UserDto> users = service.getUsers(1,1);
        assertEquals(0, users.size());
    }


}