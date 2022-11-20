package com.maveric.userservice.customHandler;

public class EmailDuplicationException extends RuntimeException{
    public EmailDuplicationException(String email){super("Email Id already exist " + email);}

}