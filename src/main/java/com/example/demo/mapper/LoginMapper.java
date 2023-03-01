package com.example.demo.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AuthenticationDetails;
import com.example.demo.entity.Users;
import com.example.demo.enums.Status;
import com.example.demo.response.LoginResponse;

@Service
public class LoginMapper {

	public static AuthenticationDetails getAuthenticationDetails(Users user, String token) {
		AuthenticationDetails authenticationDetails = new AuthenticationDetails();
		authenticationDetails.setCreatedAt(LocalDateTime.now());
		authenticationDetails.setStatus(Status.ACTIVE);
		authenticationDetails.setToken(token);
		authenticationDetails.setUpdatedAt(LocalDateTime.now());

		authenticationDetails.setUserId(user);
		return authenticationDetails;

	}

	public static LoginResponse getLoginResponse(long id, String status, String message, String token) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(id);
		loginResponse.setToken(token);
		loginResponse.setMessage(message);
		loginResponse.setStatus(status);

		return loginResponse;

	}

	public static LoginResponse getUserLoginResponse(long id, String status, String message, String token) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(id);
		loginResponse.setToken(token);
		loginResponse.setMessage(message);
		loginResponse.setStatus(status);
		return loginResponse;

	}

}
