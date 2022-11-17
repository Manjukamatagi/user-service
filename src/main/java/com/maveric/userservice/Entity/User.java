package com.maveric.userservice.Entity;

import com.maveric.userservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Valid
    @NotBlank
    @NotNull(message = "First name can not be null")
    private String firstName;

    @Valid
    @NotBlank
    @NotNull(message = "Last name can not be empty")
    private String lastName;
    private String middleName;


    @Pattern(regexp = "^\\d{10}$" , message = "Invalid mobile number format")
    private String phoneNumber;

    @Email(message = "Invalid mail format")
    private String email;

    @Valid
    @NotBlank
    @NotNull(message = "Address can not be empty")
    private String address;

    @Valid
    @NotNull(message = "Date of birth can not be empty")
    private Date dateOfBirth;

    @Valid
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Valid
    @NotBlank
    @NotNull(message = "Password can not be null")
    private String password;
}