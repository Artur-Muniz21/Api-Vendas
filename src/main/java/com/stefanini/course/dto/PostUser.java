package com.stefanini.course.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.stefanini.course.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
public class PostUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Nome obrigatório")
	private String name;
	
	@NotBlank(message = "Email obrigatório")
	//expressão logica tbm pode ser usada com o @Pattern
	//@Pattern(regexp = "^(?=.*[A-Za-z0-9+_.-]@)(?=.*@gmail\\.com|@outlook\\.com).*$", message = "O email deve ser do formato conteudo@gmail.com ou conteudo@outlook.com")
	@Email(message = "O email deve ser válido!") //padrão RFC 882 user@exemple.com
	private String email;
	private String phone;
	
	//validação de regras da senha
	@NotBlank(message = "Senha obrigatória")
	@Size(min = 8, message = "A senha deve conter 8 caracteres")
	private String password;

	public PostUser(){
		
	}
	
	public PostUser(Long id, String name, String email, String phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	public User toUser() {
		return new User(null, this.name, this.email, this.phone, this.password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


}
