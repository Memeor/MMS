package com.memeor.mms;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsApplication.class, args);
	}
	
	@Bean
	public StrongPasswordEncryptor passwordEncryptor() {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		return passwordEncryptor;
	}

}
