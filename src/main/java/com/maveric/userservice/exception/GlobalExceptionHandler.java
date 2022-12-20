package com.maveric.userservice.exception;

import com.maveric.userservice.dto.ErrorDto;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.maveric.userservice.constants.Constants.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);
    String exceptionString="";

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ErrorDto handleUserNotFoundException(UserNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(USER_NOT_FOUND_CODE);
        errorDto.setMessage(exception.getMessage());
        exceptionString = exception.getMessage();
        log.error("{} -> {}",USER_NOT_FOUND_CODE,exceptionString);
        return errorDto;
    }

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ErrorDto invalidException(InvalidException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(USER_NOT_FOUND_CODE);
        errorDto.setMessage(exception.getMessage());
        exceptionString = exception.getMessage();
        log.error("{}->{}",USER_NOT_FOUND_CODE,exceptionString);
        return errorDto;
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDto handleUserAlreadyExistException(UserAlreadyExistException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BAD_REQUEST_CODE);
        errorDto.setMessage(exception.getMessage());
        exceptionString = exception.getMessage();
        log.error("{}->{}",BAD_REQUEST_CODE,exceptionString);
        return errorDto;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BAD_REQUEST_CODE);
        errorDto.setMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        exceptionString = ex.getMessage();
        log.error("{}->{}->{}",BAD_REQUEST_CODE,ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),exceptionString);
        return errorDto;
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorDto handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(METHOD_NOT_ALLOWED_CODE);
        errorDto.setMessage(METHOD_NOT_ALLOWED_MESSAGE);
        log.error("{} -> {}",METHOD_NOT_ALLOWED_CODE,METHOD_NOT_ALLOWED_MESSAGE);
        return errorDto;
    }
}
