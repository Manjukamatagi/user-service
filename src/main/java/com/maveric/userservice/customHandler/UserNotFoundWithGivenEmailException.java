package com.maveric.userservice.customHandler;

public class UserNotFoundWithGivenEmailException extends RuntimeException {
public UserNotFoundWithGivenEmailException(String message) {
    super("User not found for given Email : "+message );
}
}
