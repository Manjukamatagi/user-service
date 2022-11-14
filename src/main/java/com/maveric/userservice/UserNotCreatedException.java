package com.maveric.userservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotCreatedException extends  RuntimeException {
    @ExceptionHandler(value = UserNotCreatedException.class )
    public ResponseEntity<Object> userNotCreatedException(UserNotCreatedException exception) {
        return new ResponseEntity<>("No proper user details in the request body", HttpStatus.NOT_ACCEPTABLE);
    }


}
