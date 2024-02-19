package com.Deli.example.DeliFoodApp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	

	public UserNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
}
