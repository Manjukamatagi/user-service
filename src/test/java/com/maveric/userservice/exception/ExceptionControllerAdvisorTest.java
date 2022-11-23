package com.maveric.userservice.exception;

import com.maveric.userservice.dto.ErrorDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionControllerAdvisorTest     {
    private GlobalControllerAdvisor controllerAdvisor = new GlobalControllerAdvisor();

    @Test
    void invalidException() {
        InvalidException exception = new InvalidException("User Not found");
        ErrorDto error = controllerAdvisor.invalidException(exception);
        assertEquals("404",error.getCode());
    }
    @Test
    void handleUserNotFoundException() {
        UserNotFoundException exception = new UserNotFoundException("User Not found");
        ErrorDto error = controllerAdvisor.handleUserNotFoundException(exception);
        assertEquals("404",error.getCode());
    }

}
