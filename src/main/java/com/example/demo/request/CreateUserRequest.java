package com.example.demo.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateUserRequest {

	@NotBlank(message = "Full name is mandatory")
	@Pattern(message = "Provide valid full name", regexp = "^[ A-Za-z]*$")
	private String fullName;

	@Size(min = 10, max = 10, message = "Provide your 10 digits mobile number")
	@Digits(fraction = 0, integer = 10, message = "Only Digits are accepted not Other character")
	private String mobileNumber;

	@Email
	private String emailId;

	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=()])(?=\\S+$).{8,20}$", message = "Password must have atleast 1 Number,1 Uppercase character,1 Lowercase character,1 Special character and length btw 8 and 20")
	private String password;

	@NotBlank(message = "state name is mandatory")
	private String state;

	@NotBlank(message = "country name is mandatory")
	private String country;

	@NotBlank(message = "Address is mandatory")
	@Pattern(message = "Please provide your address without any spaces", regexp = "^[ 0-9A-Za-z]*$")
	private String address;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
