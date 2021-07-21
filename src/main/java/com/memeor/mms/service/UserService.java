package com.memeor.mms.service;

import java.util.List;

import com.memeor.mms.beans.User;
import com.memeor.mms.beans.UserRegistrationResponse;

public interface UserService {

	public List<User> getAllUsers();

	public UserRegistrationResponse saveUser(User user);
	
	public void updateUser(User user);

	public boolean checkIfUserExists(String username);

	boolean checkIfEmailAlreadyRegistered(String emailAddress);

}