package com.maveric.userservice.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ErrorResponseForBadRequest {
    HttpStatus code;
    String message;
}
