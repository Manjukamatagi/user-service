package com.maveric.userservice.controller;

import com.maveric.userservice.Entity.User;
import com.maveric.userservice.Service.UserService;
import com.maveric.userservice.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class userController {
    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    /**
    * Find by id done
    * */
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") Integer userId){

         return userService.getUserById(userId);


    }
/**
 * Create user done
 */

    @PostMapping
    public String createUser(@RequestBody  User user){
//        System.out.println(user.toString());
//        User user1=modelMapper.map(userDto,User.class);

     String msg=
             userService.createUser(user);
     return msg;

    }





    /**
     * Update Userby ID
     * @param user
     * @param userId
     * @return
     */
    @PutMapping("/{id}")
    public User
    updateUser(@RequestBody User user,
               @PathVariable("id") int userId)
    {
        return userService.updateUser(userId,user);

    }

    /**
     * Get ALL USERS
     * @return
     */
    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * Delete User by ID
     * @param userId
     * @return
     */
    @DeleteMapping("/{id}")
    public String
    deleteUser(@PathVariable("id") int userId)
    {
        return userService.deleteUser(userId);

    }
}
