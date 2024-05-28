package com.stefanini.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stefanini.course.entities.User;
import com.stefanini.course.repositories.UserRepository;
import com.stefanini.course.services.exceptions.DatabaseException;
import com.stefanini.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> findAll() {

		List<User> entity = repository.findAll();
		return entity;
	}

	public User findById(Long id) {
		User obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		return obj;
	}

	public User insert(User obj) {

		boolean userEmail = repository.existsByEmail(obj.getEmail());

		if (userEmail) {
			throw new DatabaseException("Email já cadastrado!");
		}

		String encodePassword = passwordEncoder.encode(obj.getPassword());
		obj.setPassword(encodePassword);

		return repository.save(obj);

	}

	public void delete(Long id) {
		try {
			
			repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

			repository.deleteById(id);

			// RuntimeException generico para erros de execução, usar para achar o nomde da
			// exceção
			// e.printStackTrace() mostra o tipo de exceção gerada
		} catch (EmptyResultDataAccessException e) {

			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException e) {

			throw new DatabaseException(e.getMessage()); // exceção da camada de serviço

		}
	}

	public User update(Long id, User obj) {
		try {
			repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			
			User entity = repository.getReferenceById(id); // deixa um obk monitorado pelo JPA para depois efetuar uma

			if (obj.getName() != null) {
				entity.setName(obj.getName());
			}

			if (obj.getEmail() != null) {
				entity.setEmail(obj.getEmail());
			}

			if (obj.getPhone() != null) {
				entity.setPhone(obj.getPhone());
			}

			if (obj.getPassword() != null) {
				entity.setPassword(passwordEncoder.encode(obj.getPassword()));
			}

			return repository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id); // erro na busca do id
		}
	}
}