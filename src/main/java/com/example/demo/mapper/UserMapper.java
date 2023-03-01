package com.example.demo.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.example.demo.common.Constants;
import com.example.demo.entity.LoginCredentials;
import com.example.demo.entity.UserAddress;
import com.example.demo.entity.Users;
import com.example.demo.enums.Status;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.response.SuccessResponse;

public class UserMapper {

	private UserMapper() {
	}

	public static Users getUser(CreateUserRequest userRequest, Users users) {

		BeanUtils.copyProperties(userRequest, users);
		users.setFullName(userRequest.getFullName());
		users.setEmail(userRequest.getEmailId());
		users.setMobileNumber(userRequest.getMobileNumber());
		users.setCreatedAt(LocalDateTime.now());
		users.setUpdatedAt(LocalDateTime.now());
		return users; 
	}

	public static LoginCredentials getUserCredentials(CreateUserRequest userRequest, LoginCredentials userCredentials,
			String password, Users user) {

		BeanUtils.copyProperties(userRequest, userCredentials);

		userCredentials.setUsername(userRequest.getEmailId());
		userCredentials.setPassword(password);
		userCredentials.setStatus(Status.ACTIVE);
		userCredentials.setCreatedAt(LocalDateTime.now());
		userCredentials.setUpdatedAt(LocalDateTime.now());
		userCredentials.setUserId(user);
		return userCredentials;
	}
	

	public static SuccessResponse toResponse(Users user) {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setId(user.getId());
		successResponse.setMessage(Constants.USER_CREATED);
		return successResponse;
	}

	public static UserAddress getUserAddress(CreateUserRequest userRequest, UserAddress userAddress, Users user) {

		BeanUtils.copyProperties(userRequest, userAddress);
		userAddress.setAddress(userRequest.getAddress());
		userAddress.setCountry(userRequest.getCountry());
		userAddress.setState(userRequest.getState());
		userAddress.setCreatedAt(LocalDateTime.now());
		userAddress.setUpdatedAt(LocalDateTime.now());
		userAddress.setUserId(user);
		return userAddress;

	}

}
