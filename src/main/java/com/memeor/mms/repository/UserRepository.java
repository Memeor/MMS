package com.memeor.mms.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.memeor.mms.beans.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer>{

	@Modifying
	@Query("update mms_user u set u.password = :password where u.id = :id")
	void updatePassword(@Param(value = "id") Integer id, @Param(value = "password") String password);
	
	@Query("select count(*) = 1 from mms_user where username = :username")
	public Boolean checkIfUserExists(@Param(value= "username") String username);

	@Query("select count(*) = 1 from mms_user where email_address = :emailAddress")
	public Boolean checkIfEmailAlreadyRegistered(String emailAddress);

}
