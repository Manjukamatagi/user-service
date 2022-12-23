//package com.maveric.userservice.exception;
//
//import com.maveric.userservice.dto.ErrorDto;
//import org.slf4j.Logger;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import static com.maveric.userservice.constants.Constants.BAD_REQUEST_CODE;
//import static com.maveric.userservice.constants.Constants.USER_NOT_FOUND_CODE;
//
//
//
//@RestControllerAdvice
//public class GlobalExceptionController {
//
//    private static final Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionController.class);
//
//    String exceptionString="";
//    @ExceptionHandler(InvalidException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public final ErrorDto invalidException(InvalidException exception) {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setCode(USER_NOT_FOUND_CODE);
//        errorDto.setMessage(exception.getMessage());
//        exceptionString = exception.getMessage();
//        log.error("{}->{}",USER_NOT_FOUND_CODE,exceptionString);
//        return errorDto;
//    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorDto handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setCode(BAD_REQUEST_CODE);
//        errorDto.setMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//        exceptionString = ex.getMessage();
//        log.error("{}->{}->{}",BAD_REQUEST_CODE,ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),exceptionString);
//        return errorDto;
//    }
//}
