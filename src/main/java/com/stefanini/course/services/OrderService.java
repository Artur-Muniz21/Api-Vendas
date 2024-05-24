package com.stefanini.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stefanini.course.entities.Order;
import com.stefanini.course.repositories.OrderRepository;
import com.stefanini.course.services.exceptions.DatabaseException;
import com.stefanini.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderItemService orderItemService;
	
	public List<Order> findAll(){
		List<Order> list = repository.findAll();
		return list;
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
	public Order insert(Order obj) {
		Order order = repository.save(obj);
		
		order.getItems().forEach(item -> {
			item.setOrder(order);
			
			orderItemService.insert(item);
		});
		
		return order;
		
	}
	
	public void delete(Long id) {
		try {
			
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e){ 
			
			throw new ResourceNotFoundException(id);
			
		}catch(DataIntegrityViolationException  e) {
			
			throw new DatabaseException(e.getMessage()); // exceção da camada de serviço
			
		}
	}
	
	public Order update(Long id, Order obj) {
		try {
			Order entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Order entity, Order obj) {
		entity.setClient(obj.getClient());
		entity.setId(obj.getId());
		entity.setMoment(obj.getMoment());
		entity.setOrderStatus(obj.getOrderStatus());
		entity.setPayment(obj.getPayment());
	}
}
