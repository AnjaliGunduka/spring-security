package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EncryptionException extends RuntimeException{
	public EncryptionException(String errMsg) {
		super(errMsg);
	}
	
	public EncryptionException(String message, Throwable cause) {
        super(message, cause);
    }
}
