package com.maveric.userservice.dto;

import lombok.Data;

@Data
public class ErrorResponseForUserNotFound {
    String code;
    String message;
}
