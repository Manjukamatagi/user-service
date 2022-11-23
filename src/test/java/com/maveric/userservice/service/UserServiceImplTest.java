package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
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
import java.util.Optional;

import static com.maveric.userservice.UserServiceApplicationTests.getUser;
import static com.maveric.userservice.UserServiceApplicationTests.getUserDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    void getUserDetails() {
        when(repository.findById("2")).thenReturn(Optional.of(getUser()));
        when(mapper.map(any(User.class))).thenReturn(getUserDto());
        UserDto userDto = service.getUserDetails("2");
        assertSame(userDto.getFirstName(),getUserDto().getFirstName());

      }
}
