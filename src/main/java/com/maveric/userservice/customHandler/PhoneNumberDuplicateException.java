package com.maveric.userservice.customHandler;

public class PhoneNumberDuplicateException extends RuntimeException{
    public PhoneNumberDuplicateException(String phoneNumber){
        super("User with phone number already exist " + phoneNumber);
    }
}
