package com.stefanini.course.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.course.dto.GetUser;
import com.stefanini.course.dto.PostUser;
import com.stefanini.course.dto.PutUser;
import com.stefanini.course.dto.response.UserResponse;
import com.stefanini.course.entities.User;
import com.stefanini.course.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
@Validated
public class UserResource {
	
	@Autowired
	private UserService service;

	
	//apenas a lista retorna 200
	@GetMapping
	public List<GetUser> findAll(){
		
		List<GetUser> list = service.findAll().stream()
				.map(GetUser::new) //
				.collect(Collectors.toList());
		
		return list;
	}
	
	@GetMapping(value = "{id}")
	public GetUser findById(@PathVariable Long id) {
		User obj = service.findById(id);
		GetUser dto = new GetUser(obj);
		return dto;
	}
	
	//@Valid permite efetuar as validações 
	@PostMapping
	public ResponseEntity<UserResponse> insert(@Valid @RequestBody PostUser obj){
		User user = obj.toUser();
		user = service.insert(user);
		UserResponse userResponse = new UserResponse(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
				
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody PutUser  obj){
		User user = obj.toUser();
		user = service.update(id, user);
		UserResponse userResponse = new UserResponse(user);
		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
		//return ResponseEntity.ok().body(obj); => ok() = status(HttpStatus.OK)
	}
}
