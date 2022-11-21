package com.maveric.userservice.exception;

import lombok.Data;

@Data
public class ErrorResponseForBadRequest {
    String code;
    String message;
}
