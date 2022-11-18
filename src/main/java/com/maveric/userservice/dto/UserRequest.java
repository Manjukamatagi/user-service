package com.maveric.userservice.dto;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserRequest {
    @NotNull(message = "firstName con not be null")
    private String firstName;
    @NotNull(message = "lastname can not be null")
    private String lastName;
    @NotNull(message = "middleName can not be null")
    private String middleName;
    @NotNull(message = "phoneNumber can not be null")
    private String phoneNumber;
    @NotNull(message = "email can not be null")
    private String email;
    @NotNull(message = "address can not be null")
    private String address;
    @NotNull(message = "dateOfBirth can not be null")
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "gender can not be null")
    private String gender;
    @NotNull(message = "password can not be null")
    private String password;
}
