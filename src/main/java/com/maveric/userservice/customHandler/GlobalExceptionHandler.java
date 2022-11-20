package com.maveric.userservice.customHandler;

import com.maveric.userservice.dto.ErrorResponseForBadRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(value = EmailDuplicationException.class)
    public ResponseEntity<Object> duplicateElementsException(EmailDuplicationException e){
        ErrorResponseForBadRequest errorResponse = new ErrorResponseForBadRequest();
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
