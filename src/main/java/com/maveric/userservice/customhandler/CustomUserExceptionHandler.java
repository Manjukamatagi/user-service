package com.maveric.userservice.customhandler;

import com.maveric.userservice.exception.UserNotFoundForIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomUserExceptionHandler {
    @ExceptionHandler
    public ResponseEntity noUserFoundForGivenIdException(UserNotFoundForIdException ex) {
        return new ResponseEntity<>(responseDto, HttpStatus.NotFound);
    }
}
