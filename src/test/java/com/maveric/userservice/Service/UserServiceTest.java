package com.maveric.userservice.Service;


import com.maveric.userservice.dao.UserRepository;
import com.maveric.userservice.Entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

//    @BeforeAll
//    public void setUp(){
//        userRepository = Mockito.mock(UserRepository.class);
//        userService = UserServiceImpl.builder().userRepository(userRepository).build();
////         user = User.builder().uniqueId(1).firstName("t").build();
//        user = User.builder().uniqueId(1).firstName("manju").lastName("ka").middleName("k").
//                phoneNumber("ph").email("user@example.com").address("bang").build();
//    }

    @Test
    public void createUserTest(){
        Mockito.when(userRepository.save(user)).thenReturn(user);
    }

}
