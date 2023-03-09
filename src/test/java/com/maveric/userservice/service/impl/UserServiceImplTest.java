package com.maveric.userservice.service.impl;

import com.maveric.userservice.constant.Gender;
import com.maveric.userservice.converter.DtoToModelConverter;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.dto.UserEmailDto;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository mockedUserRepository;

    @Mock
    private DtoToModelConverter dtoToModelConverter;

    @InjectMocks
    private UserServiceImpl mockedUserService;

    @Test
    void createUser(){
        when(dtoToModelConverter.dtoToUserCreate(any(UserDto.class))).thenReturn(getUser());
        when(mockedUserRepository.findUserByEmail(any())).thenReturn( Optional.empty ());
        when(mockedUserRepository.save(any(User.class))).thenReturn(getUser());
        when(dtoToModelConverter.userToDtoCreate(any(User.class))).thenReturn(getUserDto());

        UserDto userDto = mockedUserService.createUser(getUserDto());

        assertNotNull(userDto);
        assertSame(userDto.getEmail(),getUser().getEmail());
    }

    @Test
    void updateUser(){
        when(mockedUserRepository.findById("1L")).thenReturn(Optional.ofNullable(getUser()));
        when(dtoToModelConverter.userToDtoUpdate(mockedUserRepository.save(getUser()))).thenReturn(getUserDto());

        UserDto user = mockedUserService.updateUser(getUserDto(), "1L");

        assertNotNull(user);
        assertSame(user.getEmail(),getUser().getEmail());
    }

    @Test
    void getAllUsers(){
        Page<User> page = new PageImpl<>(Arrays.asList(getUser(), getUser()));
        when(mockedUserRepository.findAll(any(Pageable.class))).thenReturn(page);
        when(dtoToModelConverter.userToDtoUpdate(any(User.class))).thenReturn(getUserDto());

        List<UserDto> userDtos = mockedUserService.getAllUsers(0,1);

        assertNotNull(userDtos);
        assertSame(userDtos.get(0).getEmail(), getUser().getEmail());
    }

    @Test
    void getUserById(){

        when(mockedUserRepository.findById("1L")).thenReturn(Optional.of(getUser()));
        when(dtoToModelConverter.userToDtoUpdate(any(User.class))).thenReturn(getUserDto());

        UserDto userDto = mockedUserService.getUserById("1L");

        assertNotNull(userDto);
        assertSame(userDto.getEmail(), getUser().getEmail());
    }

    @Test
    void getUserByEmail(){
        when(mockedUserRepository.findUserByEmail("manju@maveric-systems.com")).thenReturn(Optional.of(getUser()));
        when(dtoToModelConverter.userToDtoEmail(any(User.class))).thenReturn(getUserEmailDto());

        UserEmailDto user = mockedUserService.getUserByEmail("manju@maveric-systems.com");

        assertNotNull(user);
        assertSame(user.getEmail(),getUser().getEmail());
    }

    @Test
    void deleteUser(){
        when(mockedUserRepository.findById("1L")).thenReturn(Optional.of(getUser()));
        willDoNothing().given(mockedUserRepository).deleteById("1L");

        mockedUserService.deleteUser("1L");

        verify(mockedUserRepository).deleteById("1L");
    }

    public static User getUser() {
        User user = new User();
        user.setFirstName("Manju");
        user.setMiddleName("k");
        user.setLastName("Kamatagi");
        user.setAddress("Pune");
        user.setGender(Gender.MALE);
        user.setEmail("manju@maveric-systems.com");
        user.setPassword("Pass@word1");
        user.setDateOfBirth(Date.from(Instant.parse("1994-06-16T00:00:00Z")));
        user.setPhoneNumber("8123433645");

        return user;
    }

    public static UserDto getUserDto() {
        UserDto user = new UserDto();
        user.setFirstName("Manju");
        user.setMiddleName("k");
        user.setLastName("Kamatagi");
        user.setAddress("Pune");
        user.setGender(Gender.MALE);
        user.setEmail("manju@maveric-systems.com");
        user.setPassword("Pass@word1");
        user.setDateOfBirth(Date.from(Instant.parse("1994-06-16T00:00:00Z")));
        user.setPhoneNumber("8123433645");

        return user;
    }

    public static UserEmailDto getUserEmailDto() {
        UserEmailDto user = new UserEmailDto();
        user.setFirstName("manju");
        user.setMiddleName("D");
        user.setLastName("Kamatagi");
        user.setAddress("Mumbai");
        user.setGender(Gender.MALE);
        user.setEmail("manju@maveric-systems.com");
        user.setPassword("Pass@word1");
        user.setDateOfBirth(Date.from(Instant.parse("1994-06-16T00:00:00Z")));
        user.setPhoneNumber("8123433645");

        return user;
    }
}