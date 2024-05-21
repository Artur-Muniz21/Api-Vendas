package com.stefanini.course.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stefanini.course.dto.GetUser;
import com.stefanini.course.entities.User;
import com.stefanini.course.repositories.UserRepository;
import com.stefanini.course.services.exceptions.DatabaseException;
import com.stefanini.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		List<User> entity = repository.findAll();		
		return entity;
	}
	
	public User findById(Long id) {
	    User obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	    
	    return obj;
	}

	
	public User insert(User obj) {
	
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		try {
			
			repository.deleteById(id);
			
			//RuntimeException generico para erros de execução, usar para achar o nomde da exceção
			//e.printStackTrace() mostra o tipo de exceção gerada
		}catch(EmptyResultDataAccessException e){ 
			
			throw new ResourceNotFoundException(id);
			
		}catch(DataIntegrityViolationException  e) {
			
			throw new DatabaseException(e.getMessage()); // exceção da camada de serviço
			
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id); //deixa um obk monitorado pelo JPA para depois efetuar uma operação
			updateData(entity, obj); // atualiza o entity baseado no obj passado
			return repository.save(entity);
		}catch (EntityNotFoundException  e){
			throw new ResourceNotFoundException(id); //erro na busca do id
		}

	}
	
	public void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
