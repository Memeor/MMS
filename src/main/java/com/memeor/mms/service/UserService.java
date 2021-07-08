package com.memeor.mms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memeor.mms.beans.Users;
import com.memeor.mms.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<Users> getAllUsers(){
		
		return userRepository.findAll();
	}

}
