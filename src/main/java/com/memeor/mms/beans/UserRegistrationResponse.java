package com.memeor.mms.beans;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserRegistrationResponse {
	private RegistrationStatus status;
	private String message;
}
