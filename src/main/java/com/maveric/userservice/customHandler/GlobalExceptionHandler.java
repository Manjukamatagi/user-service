package com.maveric.userservice.customHandler;

import com.maveric.userservice.dto.ErrorResponseForUserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = UserNotFoundWithGivenEmailException.class)
    public ResponseEntity<Object> duplicateElementsException(UserNotFoundWithGivenEmailException e){
        ErrorResponseForUserNotFound errorResponse = new ErrorResponseForUserNotFound();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
