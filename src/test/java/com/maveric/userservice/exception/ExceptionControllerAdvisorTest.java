package com.maveric.userservice.exception;

import com.maveric.userservice.dto.ErrorDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ExceptionControllerAdvisorTest {
    private GlobalExceptionHandler controllerAdvisor = new GlobalExceptionHandler();

    @Test
    void handleUserAlreadyExistException() {
        UserAlreadyExistException exception = new UserAlreadyExistException("User Already Exist");
        ErrorDto error = controllerAdvisor.handleUserAlreadyExistException(exception);
        assertEquals("400",error.getCode());
      }

    @Test
    void invalidException() {
        InvalidException exception = new InvalidException("User Not found");
        ErrorDto error = controllerAdvisor.invalidException(exception);
        assertEquals("404",error.getCode());
      }

}