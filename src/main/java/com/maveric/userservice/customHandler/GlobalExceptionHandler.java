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
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> InvalidFieldException(MethodArgumentNotValidException exception){
        List<ErrorResponseForBadRequest> errorResponseList = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorResponseForBadRequest errorResponse = new ErrorResponseForBadRequest();
                    errorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
                    errorResponse.setMessage(error.getDefaultMessage());
                   errorResponseList.add(errorResponse);
                });
        return new ResponseEntity<>(errorResponseList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmailDuplicationException.class)
    public ResponseEntity<Object> duplicateElementsException(EmailDuplicationException e){
        ErrorResponseForBadRequest  errorResponse = new ErrorResponseForBadRequest();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setCode(String.valueOf(HttpStatus.CONFLICT.value()));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(value = PhoneNumberDuplicateException.class)
    public ResponseEntity<Object> duplicateElementsException(PhoneNumberDuplicateException e){
        ErrorResponseForBadRequest  errorResponse = new ErrorResponseForBadRequest();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setCode(String.valueOf(HttpStatus.CONFLICT.value()));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

}
