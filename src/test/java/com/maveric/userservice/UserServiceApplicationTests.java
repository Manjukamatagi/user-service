package com.maveric.userservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.enumeration.Gender;
import com.maveric.userservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public
class UserServiceApplicationTests {
	public static final String APIV1 ="/api/v1/users";
	public static UserDto getUserDto()
	{
		return  UserDto.builder()
				._id("8123")
				.firstName("Manju")
				.lastName("sam")
				.middleName("ma")
				.phoneNumber("8123433645")
				.email("manju@gmail.com")
				.address("Bagalkot")
				.dateOfBirth(LocalDate.parse("2020-04-15"))
				.gender(Gender.MALE)
				.build();
	}
	public static User getUser()
	{
		return  User.builder()
				._id("8123")
				.firstName("Manju")
				.lastName("sam")
				.middleName("ma")
				.phoneNumber("8123433645")
				.email("manju@gmail.com")
				.address("Bagalkot")
				.dateOfBirth(LocalDate.parse("2020-04-15"))
				.gender(Gender.MALE)
				.build();
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
