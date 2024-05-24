package com.stefanini.course.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stefanini.course.entities.User;
import com.stefanini.course.repositories.UserRepository;

@Service
public class LoginUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean log(String email, String password) {
		
		User user = userRepository.findByEmail(email);
		
		if(Objects.isNull(user)) {
			return false;
		}
		
		return passwordEncoder.matches(password, user.getPassword());
	}
}
