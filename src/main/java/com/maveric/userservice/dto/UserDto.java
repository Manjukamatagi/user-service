package com.maveric.userservice.dto;

import com.maveric.userservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String address;
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String _Id;
}
