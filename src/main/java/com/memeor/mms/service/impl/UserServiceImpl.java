package com.memeor.mms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memeor.mms.beans.RegistrationStatus;
import com.memeor.mms.beans.User;
import com.memeor.mms.beans.UserRegistrationResponse;
import com.memeor.mms.repository.UserRepository;
import com.memeor.mms.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StrongPasswordEncryptor passwordEncryptor;
	
	@Autowired
	UserRegistrationResponse userRegistrationResponse;
	
	@Override
	public List<User> getAllUsers(){
		List<User> result = new ArrayList<User>();
		userRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public UserRegistrationResponse saveUser(User user) {
		
		String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		user.setPassword(encryptedPassword);
		user.setVerified(false);
		
		String verificationToken = "sampletoken"; //TODO: get token
		
		user.setVerificationToken(verificationToken);
		boolean emailExists = checkIfEmailAlreadyRegistered(user.getEmailAddress());
		boolean userExists = checkIfUserExists(user.getUsername());
		try {
			if (!emailExists) {
				if(!userExists) {
					userRepository.save(user);
					userRegistrationResponse.setStatus(RegistrationStatus.ACCEPTED);
				} else {
					userRegistrationResponse.setStatus(RegistrationStatus.FAILED);
				}
			} else {
				if(!userExists) {
					userRegistrationResponse.setStatus(RegistrationStatus.ACCEPTED);
				} else {
					userRegistrationResponse.setStatus(RegistrationStatus.FAILED);
				}
			}
			
			
			return userRegistrationResponse;
		} catch (Exception e) {
			log.info("Error in database when trying to insert " + user.toString());
		}
		return userRegistrationResponse;
		//emailService.sendVerificationEmail(verificationToken); //TODO: send email
	}

	@Override
	public boolean checkIfUserExists(String username) {
		return userRepository.checkIfUserExists(username);
	}
	
	@Override
	public boolean checkIfEmailAlreadyRegistered(String emailAddress) {
		return userRepository.checkIfEmailAlreadyRegistered(emailAddress);
	}
	
	@Override
	public void updateUser(User user) { //TODO
		final User existingUser = userRepository.findById(user.getId()).get();
		
		String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		existingUser.setPassword(encryptedPassword);
		userRepository.updatePassword(user.getId(), encryptedPassword);
	}

}
