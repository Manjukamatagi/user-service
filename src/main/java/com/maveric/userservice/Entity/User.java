package com.maveric.userservice.Entity;

import com.maveric.userservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

@Builder

public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String _Id;
    @NotNull(message = "FirstName can not be null")
    private String firstName;
    @NotNull(message = "Last can not be null")
    private String lastName;
    @NotNull(message = "Middle can not be null")
    private String middleName;
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
    private String phoneNumber;
    @Email(message = "Enter a valid Email")
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull(message = "Address can not be empty")
    private String address;
    @NotNull(message = "Date of barth can not be empty")
    private Date dateOfBirth;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    @NotNull(message = "password can not be empty")
    private String password;

}