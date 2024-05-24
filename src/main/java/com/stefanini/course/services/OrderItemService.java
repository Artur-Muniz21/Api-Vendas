package com.stefanini.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.course.entities.OrderItem;
import com.stefanini.course.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	//get
	public List<OrderItem> findAll(){
		return repository.findAll();
	}
	
	//post
	public OrderItem insert(OrderItem obj) {
		return repository.save(obj);
	}
	
}
