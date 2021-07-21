package com.memeor.mms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memeor.mms.beans.RegistrationStatus;
import com.memeor.mms.beans.User;
import com.memeor.mms.beans.UserRegistrationResponse;
import com.memeor.mms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public List<User> getAllUsers() {
		//TODO: Delete in the future or restrict to admins
		return userService.getAllUsers();
	}
	
	//Sign Up
	@PostMapping("")
	public ResponseEntity<UserRegistrationResponse> addUser(@RequestBody User user) {
		UserRegistrationResponse userRegistrationResponse = userService.saveUser(user);
		
		if(userRegistrationResponse.getStatus().equals(RegistrationStatus.ACCEPTED))
			return new ResponseEntity<>(userRegistrationResponse, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(userRegistrationResponse, HttpStatus.CONFLICT);
	}

	@GetMapping(value="/availability/{username}")
	public ResponseEntity<Boolean> checkUsernameAvailability(@PathVariable("username") String username) {
		
		return new ResponseEntity<>(!userService.checkIfUserExists(username), HttpStatus.ACCEPTED);
	}
	
	//Edit username, email, or password
	@PutMapping("")
	public void updateUsername(@RequestBody User user) {
		//TODO: implement in the future
		userService.saveUser(user);
	}

	
	
}
