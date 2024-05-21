package com.stefanini.course.dto.response;

import java.io.Serializable;

import com.stefanini.course.entities.User;

public class UserResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String phone;

	public UserResponse(){
		
	}
	
	public UserResponse(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
	}
	
	public UserResponse(Long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public static UserResponse toResponseUsuario(User usuario) { // convertendo usuarioDto em um obj usuario
		return new UserResponse(usuario.getId(), usuario.getName(), usuario.getEmail(), usuario.getPhone());
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


}
