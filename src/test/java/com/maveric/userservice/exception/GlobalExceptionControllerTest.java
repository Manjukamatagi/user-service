//package com.maveric.userservice.exception;
//
//import com.maveric.userservice.dto.ErrorDto;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class GlobalExceptionControllerTest {
//    private GlobalExceptionController controllerAdvisor = new GlobalExceptionController();
//
//    @Test
//    void invalidException() {
//        InvalidException exception = new InvalidException("User Not found");
//        ErrorDto error = controllerAdvisor.invalidException(exception);
//        assertEquals("404",error.getCode());
//    }
//
//}
