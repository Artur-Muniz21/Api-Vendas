package com.stefanini.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.stefanini.course.entities.LoginUser;
import com.stefanini.course.services.LoginUserService;

@RestController
@RequestMapping(value = "/login")
public class LoginUserResource {

	@Autowired
	private LoginUserService service;
	
	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginUser loginUser){
		
		boolean authenticated = service.log(loginUser.getEmail(), loginUser.getPassword());
		
		if(authenticated) {
			return ResponseEntity.ok("login com sucesso");
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
		}
	}
}
