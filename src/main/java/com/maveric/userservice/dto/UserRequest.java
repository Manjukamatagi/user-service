package com.maveric.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maveric.userservice.enums.Gender;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.util.Date;

@Data
public class UserRequest {
    @Size(min = 2 , message="First Name at least 2 characters")
    @NotNull(message = "First Name can not be null")
    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @Size(min = 1 , message="Last Name at least 1 characters")
    @NotNull(message = "lastname can not be null")
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Size(min = 1 , message="Middle Name at least 1 characters")
    @NotNull(message = "middleName can not be null")
    @NotBlank(message = "Middle Name is mandatory")
    private String middleName;

    @Pattern(regexp = "^\\d{10}$" , message = "Invalid mobile number format")
    @NotNull(message = "phoneNumber can not be null")
    private String phoneNumber;

    @Email(message = "Email Should be valid")
    @NotNull(message = "email can not be null")
    private String email;

    @NotNull(message = "address can not be null")
    private String address;

    @Past(message = "Date Should be past")
    @NotNull(message = "dateOfBirth can not be null")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is mandatory 'MALE' or 'FEMALE'")
    private Gender gender;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "password can not be null")
    private String Password;
}
