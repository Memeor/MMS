package com.memeor.mms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeor.mms.beans.Users;

public interface UserRepository  extends JpaRepository<Users, Integer>{

}
