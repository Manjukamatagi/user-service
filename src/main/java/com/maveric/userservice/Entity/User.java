package com.maveric.userservice.Entity;

import com.maveric.userservice.enums.Gender;
import lombok.AllArgsConstructor;
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
//@Table

//@Builder

public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String _Id;
    @NotNull(message = "FirstName can not be null")
    private String firstName;

    @NotNull(message = "Middle can not be null")
    private String middleName;

    @NotNull(message = "FirstName can not be null")
    private String lastName;

    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
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
//    private String role;
//
//    public User(String firstName, String middleName, String lastName, String email, String phoneNumber, String address, Date dateOfBirth, Date createdAt, Date updatedAt, String password, String role) {
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.dateOfBirth = dateOfBirth;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.password = password;
//        this.role = role;
//    }

//    public User() {
//    }
//
//
//
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//
//
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "firstName='" + firstName + '\'' +
//                ", middleName='" + middleName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", address='" + address + '\'' +
//                ", dateOfBirth=" + dateOfBirth +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                ", password='" + password + '\'' +
//                ", role='" + role + '\'' +
//                '}';
//    }
//}
