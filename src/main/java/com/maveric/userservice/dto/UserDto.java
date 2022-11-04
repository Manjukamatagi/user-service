package com.maveric.userservice.dto;

import java.sql.Date;

public class UserDto {
    private int uniqueId;


    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private Date createdAt;

    private Date updatedAt;

    private String password;
    private String role;

    public UserDto() {
        System.out.println("default constructor");
    }

    public UserDto(int uniqueId, String firstName, String middleName, String lastName, String email, String phoneNumber, String address, Date dateOfBirth, Date createdAt, Date updatedAt, String password, String role) {
        this.uniqueId = uniqueId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.password = password;
        this.role = role;

        System.out.println("param constructor");
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "uniqueId=" + uniqueId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
