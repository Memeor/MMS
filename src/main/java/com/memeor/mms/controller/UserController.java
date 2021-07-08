package com.memeor.mms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memeor.mms.beans.Users;
import com.memeor.mms.repository.UserRepository;
import com.memeor.mms.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService userService;
	@GetMapping
	public List<Users> getAllUsers() {

		return userService.getAllUsers();
	}

}
