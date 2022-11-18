package com.maveric.userservice.dto;

import lombok.Data;
@Data
public class ErrorResponseForBadRequest {
    String code;
    String message;
}

