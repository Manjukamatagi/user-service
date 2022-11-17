package com.maveric.userservice.dto;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String address;
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private String gender;
    private String password;
}
