package com.maveric.userservice.customHandler;

import com.maveric.userservice.dto.ErrorResponseForBadRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class InvalidFieldException extends RuntimeException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> InvalidFieldException(MethodArgumentNotValidException exception){
        List<ErrorResponseForBadRequest> errorResponseList = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorResponseForBadRequest errorResponse = new ErrorResponseForBadRequest();
                    errorResponse.setCode(HttpStatus.BAD_REQUEST);
                    errorResponse.setMessage(error.getDefaultMessage());
                   errorResponseList.add(errorResponse);

                });
        return new ResponseEntity<>(errorResponseList, HttpStatus.BAD_REQUEST);
    }
}
