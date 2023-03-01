package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	private String status;
	private String error;

	public ErrorResponse(String status, String error) {
		super();
		this.error = error;
		this.status = status;
	}

	public ErrorResponse() {
		super();
	}

	public String getError() {
		return error;
	}

	public String getStatus() {
		return status;
	}

}
